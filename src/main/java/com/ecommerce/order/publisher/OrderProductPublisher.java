package com.ecommerce.order.publisher;

import com.ecommerce.order.dtos.OrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderProductPublisher {
    
    private final RabbitTemplate rabbitTemplate;
    @Value(value = "${ecommerce.broker.exchange.orderProductCommand}")
    private String orderProductExchange;
    @Value(value = "${ecommerce.broker.key.bindOrderProductRequestCommand}")
    private String bindOrderProductRequest;
    
    public OrderProductPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void publish(OrderDto orderDto) {
        rabbitTemplate.convertAndSend(orderProductExchange, bindOrderProductRequest, orderDto);
    }
}
