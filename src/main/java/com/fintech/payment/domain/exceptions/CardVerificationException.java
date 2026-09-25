package com.fintech.payment.domain.exceptions;

public class CardVerificationException extends RuntimeException {
    private final String cardNumber;
    private final String errorMessage;

    public CardVerificationException(String cardNumber, String errorMessage) {
        super(errorMessage);
        this.cardNumber = cardNumber;
        this.errorMessage = errorMessage;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "CardVerificationException{cardNumber='" + cardNumber + "', errorMessage='" + errorMessage + "'}";
    }
}