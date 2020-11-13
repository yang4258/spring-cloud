package com.yang.dynamicgateway.config;

import cn.hutool.core.util.StrUtil;
import com.yang.dynamicgateway.dao.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yang
 * @since 2020/11/13
 */
@Component
public class GatewayServiceHandler implements ApplicationEventPublisherAware, CommandLineRunner {
    @Autowired
    @Qualifier(value = "unifiedRouteRepositoryImpl")
    private RouteDefinitionWriter routeDefinitionWriter;
    //该类需要你自己编写（将数据库中的动态路由加载到内存中）
    @Autowired
    private RouteRepository routeRepository;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) {
        this.loadRouteConfig();
    }

    public void loadRouteConfig() {
        List<Map<String, Object>> lists = routeRepository.getListAll();
        lists.forEach(r -> {
            RouteDefinition route = new RouteDefinition();
            //设置Id
            route.setId((String) r.get("routeId"));
            try {
                route.setUri(new URI((String) r.get("uri")));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            // 可以改为集合
            // 断言配置  匹配规则
            PredicateDefinition predicate = new PredicateDefinition();
            Map<String, String> predicateParams = new HashMap<>(2);
            predicate.setName((String) r.get("predicateName"));
            predicateParams.put("pattern" , (String) r.get("predicateArgs"));
            predicate.setArgs(predicateParams);
            if (!StrUtil.isBlank(predicate.getName())) {
                route.setPredicates(Arrays.asList(predicate));
            }

            // 可以改为集合
            // 过滤器配置
            FilterDefinition filter = new FilterDefinition();
            Map<String, String> filterParams = new HashMap<>(2);
            filter.setName((String) r.get("filterName"));
            filterParams.put("_genkey_0" , (String) r.get("filterArgs"));
            filter.setArgs(filterParams);
            if (!StrUtil.isBlank(filter.getName())) {
                route.setFilters(Arrays.asList(filter));
            }
            routeDefinitionWriter.save(Mono.just(route)).subscribe();
        });
        this.publisher.publishEvent(new RefreshRoutesEvent(this));

    }

    public void deleteRoute(String routeId) {
        routeDefinitionWriter.delete(Mono.just(routeId)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

}
