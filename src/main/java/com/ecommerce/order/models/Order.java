package com.ecommerce.order.models;

import com.ecommerce.order.dtos.OrderItemsDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "TB_ORDER")
public class Order {

    @Id
    private String orderId;
    private List<OrderItemsDto> orderItems;
    private BigDecimal amount;

    public Order(List<OrderItemsDto> orderItems, BigDecimal amount) {
        this.orderItems = orderItems;
        this.amount = amount;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderItemsDto> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setOrderItems(List<OrderItemsDto> orderItems) {
        this.orderItems = orderItems;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
