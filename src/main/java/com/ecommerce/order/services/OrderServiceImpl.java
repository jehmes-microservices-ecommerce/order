package com.ecommerce.order.services;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.models.Order;
import com.ecommerce.order.publisher.OrderPublisher;
import com.ecommerce.order.repositories.OrderRepository;
import com.ecommerce.order.services.interfaces.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderPublisher orderPublisher;

    public OrderServiceImpl(OrderRepository orderRepository, OrderPublisher orderPublisher) {
        this.orderRepository = orderRepository;
        this.orderPublisher = orderPublisher;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order saveAndPublish(OrderDto orderDto) {
        var order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        order = this.save(order);
        orderPublisher.publish(orderDto);
        return order;
    }
}
