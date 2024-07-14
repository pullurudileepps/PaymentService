package org.example.paymentservice.dtos;

import lombok.Data;

@Data
public class CreatePaymentRequestDto {
    private Long orderId;
    private Long amount;
}
