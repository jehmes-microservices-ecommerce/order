package com.ecommerce.order.services;

import com.ecommerce.order.models.Order;
import com.ecommerce.order.repositories.OrderRepository;
import com.ecommerce.order.services.interfaces.OrderService;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
            orderRepository.save(order);
    }
}
