package com.ecommerce.order.dtos;

import com.ecommerce.order.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private String orderId;
    private UserDto userDto;
    private List<OrderItemsDto> orderItems;
    private PaymentDto paymentDto;
    private BigDecimal totalPrice;
    private boolean productsInStock;
    private PaymentStatus paymentStatus;

    public OrderDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<OrderItemsDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsDto> orderItems) {
        this.orderItems = orderItems;
    }

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isProductsInStock() {
        return productsInStock;
    }

    public void setProductsInStock(boolean productsInStock) {
        this.productsInStock = productsInStock;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
