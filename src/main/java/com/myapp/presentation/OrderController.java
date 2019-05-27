package com.myapp.presentation;

import com.myapp.service.OrderService;

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

}
