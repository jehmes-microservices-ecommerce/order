package com.ecommerce.order.publisher;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.enums.PaymentStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;
    @Value(value = "${ecommerce.broker.exchange.orderEvent}")
    private String orderExchange;

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(OrderDto orderDto) {
        orderDto.setPaymentStatus(PaymentStatus.PENDING);
        rabbitTemplate.convertAndSend(orderExchange, "order-payment-request", orderDto);
    }

}
