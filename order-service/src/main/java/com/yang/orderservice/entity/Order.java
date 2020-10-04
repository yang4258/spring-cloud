package com.yang.orderservice.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yang
 * @since 2020/9/24
 */
@Data
public class Order {

    private String id;
    private BigDecimal price;

}
