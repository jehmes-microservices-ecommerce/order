package com.ecommerce.order.services;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.models.Order;
import com.ecommerce.order.publisher.OrderEventPublisher;
import com.ecommerce.order.repositories.OrderRepository;
import com.ecommerce.order.services.interfaces.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher orderEventPublisher;

    public OrderServiceImpl(OrderRepository orderRepository, OrderEventPublisher orderEventPublisher) {
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
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
        orderEventPublisher.publish(orderDto);
        return order;
    }
}
