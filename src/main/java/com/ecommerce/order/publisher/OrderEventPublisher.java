package com.ecommerce.order.publisher;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.dtos.OrderItemsDto;
import com.ecommerce.order.models.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    @Value(value = "${ecommerce.broker.exchange.orderEvent}")
    private String orderExchange;

    public OrderEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(OrderDto orderDto) {
        rabbitTemplate.convertAndSend(orderExchange, "order-payment-request", orderDto);
    }

}
