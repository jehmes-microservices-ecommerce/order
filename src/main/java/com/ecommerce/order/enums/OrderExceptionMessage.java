package com.ecommerce.order.enums;

public enum OrderExceptionMessage {
    NOT_FOUND("Order not found");

    private final String message;

    OrderExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
