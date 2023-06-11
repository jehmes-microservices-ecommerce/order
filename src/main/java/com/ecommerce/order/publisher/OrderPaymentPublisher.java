package com.ecommerce.order.publisher;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.enums.PaymentStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderPaymentPublisher {

    private final RabbitTemplate rabbitTemplate;
    @Value(value = "${ecommerce.broker.exchange.orderPaymentCommand}")
    private String orderPaymentExchange;
    @Value(value = "${ecommerce.broker.key.bindOrderPaymentRequestCommand}")
    private String bindOrderPayment;

    public OrderPaymentPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(OrderDto orderDto) {
        orderDto.setPaymentStatus(PaymentStatus.PENDING);
        rabbitTemplate.convertAndSend(orderPaymentExchange, bindOrderPayment, orderDto);
    }

}
