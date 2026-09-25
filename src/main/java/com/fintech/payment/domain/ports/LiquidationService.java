package com.fintech.payment.domain.ports;

import com.fintech.payment.domain.model.Payment;

public interface LiquidationService {
    Payment processLiquidation(Payment payment);
}