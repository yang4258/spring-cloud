package com.yang.orderview.feginservice.impl;

import com.yang.orderview.entity.Order;
import com.yang.orderview.feginservice.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {


    @Override
    public Order findById(String id) {
        Order order = new Order();
        return order;
    }
}
