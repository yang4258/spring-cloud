package com.yang.orderservice.controller;

import com.yang.orderservice.entity.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author yang
 * @since 2020/9/24
 */
@RestController
public class OrderController {

    @Value("${orderid}")
    private String id;

    @RequestMapping("/findById")
    public Order findById() {
        System.out.println("service: " + id);
        Order order = new Order();
        order.setId(id);
        order.setPrice(new BigDecimal(100));
        return order;
    }

}
