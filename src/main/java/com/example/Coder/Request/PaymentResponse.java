package com.example.Coder.Request;

import lombok.Data;

@Data
public class PaymentResponse {
    private String transactionId;
    private boolean success;
    private String message;
    
}
