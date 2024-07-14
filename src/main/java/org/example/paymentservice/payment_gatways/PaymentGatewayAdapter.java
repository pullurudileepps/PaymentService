package org.example.paymentservice.payment_gatways;

public interface PaymentGatewayAdapter {
    String createPaymentLink(long orderId, long amount) throws Exception;
}
