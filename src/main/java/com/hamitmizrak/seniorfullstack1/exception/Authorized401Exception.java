package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 401 Hatasını yakalamak
// 401: Yetkisiz Giriş
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class Authorized401Exception extends RuntimeException{

    public Authorized401Exception(String message) {
        super(message);
    }
}
