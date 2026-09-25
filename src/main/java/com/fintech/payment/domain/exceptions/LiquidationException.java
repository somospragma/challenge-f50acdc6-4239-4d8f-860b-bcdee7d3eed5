package com.fintech.payment.domain.exceptions;

import jakarta.validation.ValidationException;

public class LiquidationException extends ValidationException {
    public LiquidationException(String message) {
        super(message);
    }
    public LiquidationException(String message, Throwable cause) {
        super(message, cause);
    }
}