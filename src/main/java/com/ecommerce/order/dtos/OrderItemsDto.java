package com.ecommerce.order.dtos;

import jakarta.validation.constraints.NotNull;

public record OrderItemsDto(@NotNull String productId, @NotNull Integer quantity){

}
