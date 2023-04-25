package com.ecommerce.order.dtos;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private String orderId;
    private List<OrderItemsDto> orderItems;
    private BigDecimal amount;
    private PaymentDto paymentDto;

    public OrderDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }
}
