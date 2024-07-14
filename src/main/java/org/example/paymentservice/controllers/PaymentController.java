package org.example.paymentservice.controllers;

import org.example.paymentservice.dtos.CreatePaymentRequestDto;
import org.example.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createPaymentLink(@RequestBody CreatePaymentRequestDto requestDto) {
        try {
            String paymentLink = this.paymentService.createPaymentLink(requestDto.getOrderId(), requestDto.getAmount());
            return new ResponseEntity<>(paymentLink, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
