package com.payment.momo.service;

import com.payment.momo.dto.PaymentRequest;
import com.payment.momo.dto.PaymentResponse;
public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest request);

    PaymentResponse getPayment(Long id);
}