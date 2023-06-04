package com.ecommerce.order.consumers;

import com.ecommerce.order.dtos.UserEventDto;
import com.ecommerce.order.services.interfaces.UserService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    private final UserService userService;

    public UserConsumer(UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ecommerce.broker.queue.userEvent}", durable = "true"),
            exchange = @Exchange(value = "${ecommerce.broker.exchange.userEvent}", type = ExchangeTypes.FANOUT, ignoreDeclarationExceptions = "true")))
    public void listenUserEvent(UserEventDto userEventDto) {
        switch (userEventDto.getActionType()) {
            case CREATE,UPDATE -> userService.save(userEventDto.convertToUser());
        }
    }
}
