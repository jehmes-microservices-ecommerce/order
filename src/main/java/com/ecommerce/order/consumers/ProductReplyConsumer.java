package com.ecommerce.order.consumers;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.enums.PaymentStatus;
import com.ecommerce.order.enums.ProductOutOfBoundsException;
import com.ecommerce.order.exceptions.OrderException;
import com.ecommerce.order.publisher.OrderPaymentPublisher;
import com.ecommerce.order.services.interfaces.OrderService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProductReplyConsumer {

    private final OrderPaymentPublisher orderPaymentPublisher;
    private final OrderService orderService;

    public ProductReplyConsumer(OrderPaymentPublisher orderPaymentPublisher, OrderService orderService) {
        this.orderPaymentPublisher = orderPaymentPublisher;
        this.orderService = orderService;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ecommerce.broker.queue.orderProductReply}", durable = "true"),
            exchange = @Exchange(value = "${ecommerce.broker.exchange.orderProductCommand}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ecommerce.broker.key.bindOrderProductReplyCommand}"))
    public void listenProductCommand(@Payload OrderDto orderDto) {
        try {
            if (!orderDto.isProductsInStock()) {
                orderService.update(orderDto);
                throw new OrderException(ProductOutOfBoundsException.OUT_OF_BOUNDS.getMessage());
            }
            orderPaymentPublisher.publish(orderDto);
        } catch (OrderException e) {
            e.printStackTrace();
        }
    }
}
