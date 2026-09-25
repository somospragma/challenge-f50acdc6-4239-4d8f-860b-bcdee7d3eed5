package com.fintech.payment.infrastructure.controllers;


import com.fintech.payment.domain.ports.CardVerificationResult;
import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.PaymentRepository;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.LiquidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;
    private final CardVerificationService cardVerificationService;
    private final LiquidationService liquidationService;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository, CardVerificationService cardVerificationService, LiquidationService liquidationService) {
        this.paymentRepository = paymentRepository;
        this.cardVerificationService = cardVerificationService;
        this.liquidationService = liquidationService;
    }

    @PostMapping
    public ResponseEntity<Payment> initiatePayment(@RequestBody Payment payment) {
        // Verify the card
        CardVerificationResult result = cardVerificationService.verifyCard(payment);
        if (result!= CardVerificationResult.APPROVED) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(null);
        }

        // Save the payment
        Payment savedPayment = paymentRepository.save(payment);

        // Liquidate the payment
        liquidationService.liquidatePayment(savedPayment);

        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable UUID id) {
        return paymentRepository.findById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }
}