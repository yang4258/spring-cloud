package com.yang.dynamicgateway.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author yang
 * @since 2020/11/13
 */
@Component
public class RouteRepository {

    public List<Map<String, Object>> getListAll() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("routeId" , "path_route_atguigu");
        map.put("uri" , "http://news.baidu.com/guonei");
        map.put("predicateName" , "Path");
        map.put("predicateArgs" , "/guonei");
        list.add(map);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("routeId" , "taiji");
        map1.put("uri" , "http://192.168.3.131:8080/");
        map1.put("predicateName" , "Path");
        map1.put("predicateArgs" , "/css/**");
        list.add(map1);

        Map<String, Object> map12 = new HashMap<>();
        map12.put("routeId" , "suzhou");
        map12.put("uri" , "http://127.0.0.1:6004/");
        map12.put("predicateName" , "Path");
        map12.put("predicateArgs" , "/znCollectlistIntranet/**");
        list.add(map12);

        return list;
    }

}

