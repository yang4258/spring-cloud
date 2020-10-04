package com.yang.orderview.feginservice;

import com.yang.orderview.config.FeignConfig;
import com.yang.orderview.entity.Order;
import com.yang.orderview.feginservice.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yang
 * @since 2020/9/27
 */
@FeignClient(value = "order-service", configuration = FeignConfig.class, fallback = OrderServiceImpl.class)
public interface OrderService {

    @RequestMapping(value = "/findById")
    Order findById(@RequestParam("id") String id);

}
