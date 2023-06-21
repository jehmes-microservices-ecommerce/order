package com.ecommerce.order.consumers;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.enums.OrderStatus;
import com.ecommerce.order.enums.PaymentStatus;
import com.ecommerce.order.exceptions.OrderException;
import com.ecommerce.order.services.interfaces.OrderService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentReplyConsumer {

    private final OrderService orderService;

    public PaymentReplyConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ecommerce.broker.queue.orderPaymentReply}", durable = "true"),
            exchange = @Exchange(value = "${ecommerce.broker.exchange.orderPaymentCommand}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ecommerce.broker.key.bindOrderPaymentReplyCommand}"))
    public void listenPaymentCommand(@Payload OrderDto orderDto) {
        if (orderDto.getPaymentStatus().equals(PaymentStatus.APPROVED)) {
            try {
                orderDto.setOrderStatus(OrderStatus.SUCCESS.toString());
                orderService.update(orderDto);
            } catch (OrderException e) {
                e.printStackTrace();
            }
        }
    }

}
