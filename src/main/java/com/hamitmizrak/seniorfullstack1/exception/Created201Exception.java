package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 201 Hatasını yakalamak
// 201: Oluşturuldu
@ResponseStatus(value = HttpStatus.CREATED)
public class Created201Exception extends RuntimeException{

    public Created201Exception(String message) {
        super(message);
    }
}
