package com.payment.momo.dto;

import java.math.BigDecimal;

public class PaymentResponse {
    private Long id;
    private BigDecimal amount;
    private String currency;
    private String status;

    public PaymentResponse(Long id, BigDecimal amount, String currency, String status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }
}