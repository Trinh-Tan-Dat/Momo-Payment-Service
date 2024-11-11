package com.payment.momo.service.impl;

import com.payment.momo.dto.PaymentRequest;
import com.payment.momo.dto.PaymentResponse;
import com.payment.momo.momo.MoMoService;
import com.payment.momo.model.Payment;
import com.payment.momo.repository.PaymentRepository;
import com.payment.momo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final MoMoService moMoService;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, MoMoService moMoService) {
        this.paymentRepository = paymentRepository;
        this.moMoService = moMoService;
    }

    @Override
    public PaymentResponse createPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setCurrency(request.getCurrency());
        payment.setStatus("PENDING");

        Payment savedPayment = paymentRepository.save(payment);

        // Process payment with MoMo
        moMoService.processPayment(savedPayment);

        return new PaymentResponse(savedPayment.getId(), savedPayment.getAmount(), savedPayment.getCurrency(),
                savedPayment.getStatus());
    }

    @Override
    public PaymentResponse getPayment(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
            Payment p = payment.get();
            return new PaymentResponse(p.getId(), p.getAmount(), p.getCurrency(), p.getStatus());
        }
        return null; // or handle not found case appropriately
    }
}