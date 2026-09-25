package com.fintech.payment.infrastructure.error;

import com.fintech.payment.domain.exceptions.CardVerificationException;
import com.fintech.payment.domain.exceptions.IdempotencyException;
import com.fintech.payment.domain.exceptions.LiquidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CardVerificationException.class)
    public ResponseEntity<String> handleCardVerificationException(CardVerificationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(IdempotencyException.class)
    public ResponseEntity<String> handleIdempotencyException(IdempotencyException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(LiquidationException.class)
    public ResponseEntity<String> handleLiquidationException(LiquidationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}