package com.ecommerce.order.dtos;

import java.math.BigDecimal;

public class OrderItemsDto {

    private String productId;
    private String name;
    private BigDecimal price;

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
