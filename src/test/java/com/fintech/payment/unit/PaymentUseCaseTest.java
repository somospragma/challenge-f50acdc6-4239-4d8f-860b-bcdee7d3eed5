package com.fintech.payment.unit;




import com.fintech.payment.domain.exceptions.IdempotencyException;
import com.fintech.payment.domain.ports.CardVerificationResult;
import com.fintech.payment.domain.model.PaymentStatus;
import com.fintech.payment.application.usecases.PaymentUseCase;
import com.fintech.payment.domain.model.Payment;
import com.fintech.payment.domain.ports.CardVerificationService;
import com.fintech.payment.domain.ports.PaymentRepository;
import com.fintech.payment.domain.exceptions.CardVerificationException;
import com.fintech.payment.domain.exceptions.LiquidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PaymentUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CardVerificationService cardVerificationService;

    @InjectMocks
    private PaymentUseCase paymentUseCase;

    private Payment payment;

    @BeforeEach
    public void setUp() {
        payment = new Payment(UUID.randomUUID(), "1234567890123456", 100, Payment.PaymentStatus.PENDING);
    }

    @Test
    public void testProcessPaymentSuccess() {
        when(cardVerificationService.verifyCard(payment)).thenReturn(CardVerificationService.CardVerificationResult.APPROVED);
        when(paymentRepository.save(payment)).thenReturn(payment);
        paymentUseCase.processPayment(payment);
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    public void testProcessPaymentCardVerificationFailure() {
        when(cardVerificationService.verifyCard(payment)).thenReturn(CardVerificationService.CardVerificationResult.DECLINED);
        assertThrows(CardVerificationException.class, () -> paymentUseCase.processPayment(payment));
    }

    @Test
    public void testProcessPaymentLiquidationFailure() {
        when(cardVerificationService.verifyCard(payment)).thenReturn(CardVerificationService.CardVerificationResult.APPROVED);
        when(paymentRepository.save(payment)).thenThrow(new LiquidationException("Liquidation failed"));
        assertThrows(LiquidationException.class, () -> paymentUseCase.processPayment(payment));
    }

    @Test
    public void testProcessPaymentIdempotency() {
        String idempotencyKey = "idempotency-key";
        payment.withIdempotencyKey(idempotencyKey);
        when(paymentRepository.findByIdempotencyKey(idempotencyKey)).thenReturn(Optional.of(payment));
        assertThrows(IdempotencyException.class, () -> paymentUseCase.processPayment(payment));
    }
}