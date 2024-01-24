package com.example.Coder.Service;


import com.example.Coder.Request.PaymentRequest;
import com.example.Coder.Request.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest paymentRequest,Long userId);
}

