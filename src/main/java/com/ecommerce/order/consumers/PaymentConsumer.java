package com.ecommerce.order.consumers;

import com.ecommerce.order.dtos.OrderDto;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ecommerce.broker.queue.paymentReply}", durable = "true"),
            exchange = @Exchange(value = "${ecommerce.broker.exchange.orderEvent}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ecommerce.broker.key.bindOrderReply}"
    ))
    public void listenPaymentEvent(@Payload OrderDto orderDto) {
        System.out.println(orderDto);

    }

}
