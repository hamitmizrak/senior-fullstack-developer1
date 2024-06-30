package com.hamitmizrak.seniorfullstack1.exception;
/*
100–199 (Bilgi Kodları)
200–299 (Başarı Kodları)
300–399 (Yönlendirme Kodları)
400–499 (Client Hata Kodları)
500–599 (Server Hata Kodları)
* */
public class HamitMizrakException extends RuntimeException{

    // Constructor (Parametreli)
    public HamitMizrakException(String message) {
        super(message);
    } //end constructor
} //end class
