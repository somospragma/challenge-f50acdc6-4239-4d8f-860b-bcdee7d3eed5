package com.fintech.payment.domain.exceptions;

public class IdempotencyException extends RuntimeException {
    public IdempotencyException(String message) {
        super(message);
    }
    public IdempotencyException(String message, Throwable cause) {
        super(message, cause);
    }
}