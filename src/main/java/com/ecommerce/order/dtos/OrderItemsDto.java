package com.ecommerce.order.dtos;

import java.math.BigDecimal;

public class OrderItemsDto {

    private String productId;
    private String name;
    private BigDecimal price;

    public OrderItemsDto() {
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
