package com.ecommerce.order.dtos;

import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private String id;
    @Transient
    private List<OrderItemsDto> orderItems;
    private BigDecimal amount;

    public OrderDto() {
    }

    public String getId() {
        return id;
    }

    public List<OrderItemsDto> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrderItems(List<OrderItemsDto> orderItems) {
        this.orderItems = orderItems;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
