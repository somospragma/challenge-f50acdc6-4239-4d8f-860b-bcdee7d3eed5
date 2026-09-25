package com.fintech.payment.domain.model;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Payment(
    @NotNull(message = "El ID del pago no puede ser nulo")
    UUID paymentId,

    @NotNull(message = "El ID de la orden no puede ser nulo")
    @Size(min = 1, max = 64, message = "El ID de la orden debe tener entre 1 y 64 caracteres")
    String orderId,

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
    BigDecimal amount,

    @NotNull(message = "La moneda no puede ser nula")
    @Size(min = 3, max = 3, message = "La moneda debe ser un código de 3 caracteres")
    String currency,

    @NotNull(message = "El número de tarjeta no puede ser nulo")
    @Size(min = 13, max = 19, message = "El número de tarjeta debe tener entre 13 y 19 dígitos")
    String cardNumber,

    @NotNull(message = "El titular de la tarjeta no puede ser nulo")
    @Size(min = 2, max = 255, message = "El titular de la tarjeta debe tener entre 2 y 255 caracteres")
    String cardHolder,

    @NotNull(message = "La fecha de expiración no puede ser nula")
    @Future(message = "La tarjeta debe estar vigente")
    LocalDateTime cardExpiry,

    @NotNull(message = "El CVV no puede ser nulo")
    @Size(min = 3, max = 4, message = "El CVV debe tener entre 3 y 4 dígitos")
    String cardCvv,

    @NotNull(message = "El canal de pago no puede ser nulo")
    PaymentChannel channel,

    @NotNull(message = "El estado del pago no puede ser nulo")
    PaymentStatus status,

    @NotNull(message = "La fecha de creación no puede ser nula")
    LocalDateTime createdAt,

    LocalDateTime processedAt,

    String idempotencyKey
) {
    public Payment {
        if (paymentId == null) {
            paymentId = UUID.randomUUID();
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (status == null) {
            status = PaymentStatus.PENDING;
        }
    }

    public Payment withStatus(PaymentStatus newStatus) {
        return new Payment(
            this.paymentId,
            this.orderId,
            this.amount,
            this.currency,
            this.cardNumber,
            this.cardHolder,
            this.cardExpiry,
            this.cardCvv,
            this.channel,
            newStatus,
            this.createdAt,
            LocalDateTime.now(),
            this.idempotencyKey
        );
    }

    public Payment withIdempotencyKey(String key) {
        return new Payment(
            this.paymentId,
            this.orderId,
            this.amount,
            this.currency,
            this.cardNumber,
            this.cardHolder,
            this.cardExpiry,
            this.cardCvv,
            this.channel,
            this.status,
            this.createdAt,
            this.processedAt,
            key
        );
    }

    public String generateIdempotencyKey() {
        return orderId + "_" + channel.name();
    }

    public enum PaymentChannel {
        MOBILE_APP, WEB, IN_STORE, CALL_CENTER
    }

    public enum PaymentStatus {
        PENDING, PROCESSING, COMPLETED, FAILED, REJECTED
    }
}