package com.fintech.payment.domain.ports;

import com.fintech.payment.domain.model.Payment;

public interface CardVerificationService {
    CardVerificationResult verifyCard(Payment payment);

    enum CardVerificationResult {
        APPROVED,
        REJECTED,
        ERROR
    }
}