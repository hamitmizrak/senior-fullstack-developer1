package com.hamitmizrak.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// API'den gelen 403 Hatasını yakalamak
// 403: Forbidden
// 401 Unauthorized:** Kimlik doğrulama gerekli ve doğru kimlik bilgileri sağlandığında erişim izni verilebilir.
// 403 Forbidden:** Kimlik doğrulaması yapılsa bile, istemcinin erişim yetkisi yoktur ve erişim izni verilmez.
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class Forbidden403Exception extends RuntimeException{

    public Forbidden403Exception(String message) {
        super(message);
    }
}
