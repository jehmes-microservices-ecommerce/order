package com.ecommerce.order.controllers;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.models.Order;
import com.ecommerce.order.publisher.OrderEventPublisher;
import com.ecommerce.order.services.interfaces.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Object> execute(@RequestBody OrderDto orderDto) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.saveAndPublish(orderDto));
    }
}

