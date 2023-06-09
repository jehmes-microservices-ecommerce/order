package com.ecommerce.order.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OrderItemsDto(@NotNull UUID productId, @NotNull Integer quantity){

}
