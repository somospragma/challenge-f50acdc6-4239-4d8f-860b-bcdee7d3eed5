package com.fintech.payment.infrastructure.adapters;

import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.CardVerificationResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardVerificationClient implements CardVerificationService {

    private final RestTemplate restTemplate;
    private final String verificationUrl;

    public CardVerificationClient(RestTemplate restTemplate, @Value("${external.services.card-verification.url}") String verificationUrl) {
        this.restTemplate = restTemplate;
        this.verificationUrl = verificationUrl;
    }

    @Override
    public CardVerificationResult verifyCard(Payment payment) {
        try {
            // Simulate a call to an external service for card verification
            // In a real scenario, this would involve making an actual HTTP request to the external service
            // For the purpose of this example, we'll return a hardcoded result
            return CardVerificationResult.APPROVED;
        } catch (Exception e) {
            // Handle any exceptions that occur during the verification process
            throw new RuntimeException("Card verification failed", e);
        }
    }
}