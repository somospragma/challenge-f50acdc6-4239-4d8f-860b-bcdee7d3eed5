package com.fintech.payment.infrastructure.adapters;

import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.LiquidationService;
import org.springframework.stereotype.Service;

@Service
public class LiquidationServiceImpl implements LiquidationService {

    @Override
    public void liquidatePayment(Payment payment) {
        // Implement the logic for liquidating the payment
        // This could involve updating the payment status, interacting with external systems, etc.
        // For the purpose of this example, we'll just log the liquidation
        System.out.println("Liquidating payment: " + payment);
    }
}