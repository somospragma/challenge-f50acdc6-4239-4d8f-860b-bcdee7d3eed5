Feature: Payment Flow

  Scenario: Successful payment
    Given a valid payment request
    When the payment is processed
    Then the payment should be successful

  Scenario: Payment rejection
    Given an invalid payment request
    When the payment is processed
    Then the payment should be rejected

  Scenario: Temporary error
    Given a valid payment request
    When the payment service is temporarily unavailable
    Then the payment should be retried