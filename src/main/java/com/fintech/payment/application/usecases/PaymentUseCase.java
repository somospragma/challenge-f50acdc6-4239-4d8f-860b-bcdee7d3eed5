package com.fintech.payment.application.usecases;



import com.fintech.payment.domain.model.PaymentStatus;
import com.fintech.payment.domain.ports.CardVerificationResult;
import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.PaymentRepository;
import com.fintech.payment.domain.exceptions.LiquidationException;
import com.fintech.payment.domain.exceptions.IdempotencyException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final CardVerificationService cardVerificationService;

    @Autowired
    public PaymentUseCase(PaymentRepository paymentRepository, CardVerificationService cardVerificationService) {
        this.paymentRepository = paymentRepository;
        this.cardVerificationService = cardVerificationService;
    }

    @Transactional
    public Payment processPayment(@Valid @NotNull Payment payment) {
        String idempotencyKey = payment.generateIdempotencyKey();
        Optional<Payment> existingPayment = paymentRepository.findByIdempotencyKey(idempotencyKey);

        if (existingPayment.isPresent()) {
            throw new IdempotencyException("Payment with idempotency key already exists");
        }

        CardVerificationService.CardVerificationResult verificationResult = cardVerificationService.verifyCard(payment);
        if (verificationResult == CardVerificationService.CardVerificationResult.REJECTED) {
            throw new LiquidationException("Card verification failed");
        }

        payment = payment.withStatus(Payment.PaymentStatus.PROCESSING);
        payment = paymentRepository.save(payment);
        // Simulate external service call for payment liquidation
        if (Math.random() < 0.1) {
            throw new LiquidationException("External service error during liquidation");
        }
        payment = payment.withStatus(Payment.PaymentStatus.COMPLETED);
        return paymentRepository.save(payment);
    }
}