package com.ecommerce.order.services.interfaces;

import com.ecommerce.order.dtos.OrderDto;
import com.ecommerce.order.models.Order;

public interface OrderService {
    Order save(Order order);
    Order saveAndPublish(OrderDto orderDto);
}
