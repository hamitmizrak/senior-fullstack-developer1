package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 404 Hatasını yakalamak
// 404: Birşey bulunamadı
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFound404Exception extends  RuntimeException{
    public NotFound404Exception(String message) {
        super(message);
    }
}
