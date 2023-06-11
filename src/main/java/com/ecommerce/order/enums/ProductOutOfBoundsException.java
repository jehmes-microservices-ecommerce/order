package com.ecommerce.order.enums;

public enum ProductOutOfBoundsException {
    OUT_OF_BOUNDS("Product out of bounds");

    private final String message;

    ProductOutOfBoundsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
