package com.ecommerce.order.dtos;

import com.ecommerce.order.enums.PaymentStatus;
import com.ecommerce.order.models.Order;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class OrderDto {
    private String orderId;
    @NotNull
    private UserDto user;
    @NotNull
    private List<OrderItemsDto> orderItems;
    @NotNull
    private PaymentDto paymentDto;
    @NotNull
    private BigDecimal totalPrice;
    private boolean productsInStock;
    private PaymentStatus paymentStatus;
    private String message;
    private String orderStatus;

    public OrderDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Order convertToModel() {
        var order = new Order();
        BeanUtils.copyProperties(this, order);
        List<String> ordersItems = this.getOrderItems().stream().map(OrderItemsDto::productId).toList();
        order.setOrderItemsId(ordersItems);
        order.setUser(this.getUser().convertToUser());
        order.setRequestDate(LocalDateTime.now(ZoneId.of("UTC")));
        return order;
    }
}
