package com.ecommerce.order.dtos;

import java.time.LocalDateTime;

public class PaymentDto {
    private String cardNumber;
    private LocalDateTime localDateTime;

    public PaymentDto() {
    }

    public PaymentDto(String cardNumber, LocalDateTime localDateTime) {
        this.cardNumber = cardNumber;
        this.localDateTime = localDateTime;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
