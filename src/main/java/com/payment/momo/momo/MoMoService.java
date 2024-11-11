package com.payment.momo.momo;

import com.payment.momo.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class MoMoService {
    public void processPayment(Payment payment) {
        payment.setStatus("COMPLETED"); 
    }
}
