package com.fintech.payment.infrastructure.adapters;

import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, UUID>, PaymentRepository {
    Optional<Payment> findByIdempotencyKey(String idempotencyKey);
    Optional<Payment> findByOrderId(String orderId);
}