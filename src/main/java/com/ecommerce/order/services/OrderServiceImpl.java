package com.ecommerce.order.services;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.enums.OrderExceptionMessage;
import com.ecommerce.order.enums.OrderStatus;
import com.ecommerce.order.exceptions.OrderException;
import com.ecommerce.order.models.Order;
import com.ecommerce.order.publisher.OrderProductPublisher;
import com.ecommerce.order.repositories.OrderRepository;
import com.ecommerce.order.services.interfaces.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductPublisher orderProductPublisher;

    public OrderServiceImpl(OrderRepository orderRepository, OrderProductPublisher orderProductPublisher) {
        this.orderRepository = orderRepository;
        this.orderProductPublisher = orderProductPublisher;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order saveAndPublish(OrderDto orderDto) {
        var order = orderDto.convertToModel();
        order.setOrderStatus(OrderStatus.REQUESTED.toString());
        order = this.save(order);
        orderDto.setOrderId(order.getOrderId());
        orderProductPublisher.publish(orderDto);
        return order;
    }

    @Override
    public void update(OrderDto orderDto) throws OrderException {
        var order = orderDto.convertToModel();
        orderRepository.findById(order.getOrderId()).orElseThrow(() -> new OrderException(OrderExceptionMessage.NOT_FOUND.getMessage()));
        orderRepository.save(order);
    }
}
