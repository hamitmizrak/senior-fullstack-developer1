package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 400 Hatasını yakalamak
// 400: Kötü istek eğer sistem veya kullanıcı olmayan url yazarsa
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequest400Exception extends RuntimeException{

    public BadRequest400Exception(String message) {
        super(message);
    }
}
