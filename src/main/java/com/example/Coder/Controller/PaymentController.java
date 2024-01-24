package com.example.Coder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Coder.Request.PaymentRequest;
import com.example.Coder.Request.PaymentResponse;
import com.example.Coder.Service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{userId}/premium")
    public PaymentResponse processPremiumPayment(@RequestBody PaymentRequest paymentRequest,@PathVariable Long userId) {

        PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest,userId);

        
        return paymentResponse;
    }
}
