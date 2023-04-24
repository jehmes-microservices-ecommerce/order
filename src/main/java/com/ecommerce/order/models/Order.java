package com.ecommerce.order.models;

import com.ecommerce.order.dtos.OrderItemsDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document
public class Order {

    @Id
    private String id;
    @Transient
    private List<OrderItemsDto> orderItems;
    private BigDecimal amount;

}
