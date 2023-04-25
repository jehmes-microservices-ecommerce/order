package com.ecommerce.order.consumers;

import com.ecommerce.order.dtos.OrderDto;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    private final RabbitTemplate rabbitTemplate;
    @Value(value = "${ecommerce.broker.exchange.orderEvent}")
    private String orderExchange;

    public PaymentConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ecommerce.broker.queue.paymentReply}", durable = "true"),
            exchange = @Exchange(value = "${ecommerce.broker.exchange.orderEvent}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ecommerce.broker.key.bindOrderReply}"
    ))
    public void listenPaymentEvent(@Payload OrderDto orderDto) {
        System.out.println(orderDto);

    }

}
