package com.ecommerce.order.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentDto {
    private UUID paymentId;
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

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }
}
