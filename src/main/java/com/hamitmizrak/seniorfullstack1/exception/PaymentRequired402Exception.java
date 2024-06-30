package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 402 Hatasını yakalamak
// 402: Para isteniyor
@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class PaymentRequired402Exception extends RuntimeException{

    public PaymentRequired402Exception(String message) {
        super(message);
    }
}
