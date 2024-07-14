package org.example.paymentservice.services;

import org.example.paymentservice.payment_gatways.PaymentGatewayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    PaymentGatewayAdapter paymentGatewayAdapter;

    @Autowired
    public PaymentServiceImpl(PaymentGatewayAdapter paymentGatewayAdapter) {
        this.paymentGatewayAdapter = paymentGatewayAdapter;
    }

    @Override
    public String createPaymentLink(long orderId, long amount) throws Exception {
        //we will be skipping to call order service in order to get amount for order id,
        // instead we are passing random amount in the request

        //will be calling paymentGateway
        return this.paymentGatewayAdapter.createPaymentLink(orderId,amount);
    }
}
