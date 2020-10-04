package com.yang.orderview.controller;

import com.yang.orderview.entity.Order;
import com.yang.orderview.feginservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @since 2020/9/24
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/order/findById")
    public Order findByUserName(String id) {
        System.out.println(id);
        return orderService.findById(id);
    }

}
