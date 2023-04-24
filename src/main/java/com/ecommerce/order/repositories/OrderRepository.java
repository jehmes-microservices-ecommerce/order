package com.ecommerce.order.repositories;

import com.ecommerce.order.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
