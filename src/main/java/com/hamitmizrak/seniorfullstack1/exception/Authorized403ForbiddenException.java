package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 403 Hatasını yakalamak
// 403: Forbidden
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class Authorized403ForbiddenException extends RuntimeException{

    public Authorized403ForbiddenException(String message) {
        super(message);
    }
}
