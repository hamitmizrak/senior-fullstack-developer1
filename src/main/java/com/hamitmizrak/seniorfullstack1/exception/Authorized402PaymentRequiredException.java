package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 402 Hatasını yakalamak
// 402: Para isteniyor
@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class Authorized402PaymentRequiredException extends RuntimeException{

    public Authorized402PaymentRequiredException(String message) {
        super(message);
    }
}
