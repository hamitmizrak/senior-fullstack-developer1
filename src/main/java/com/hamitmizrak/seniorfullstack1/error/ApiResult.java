package com.hamitmizrak.seniorfullstack1.error;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

// LOMBOK
// @Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// jackson: Objeyi json'a çevirmek
// Eğer aşağıdaki datalardan null değer varsa frontent'te gösterme
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    // Field: s e m  p v c
    private int status;
    private String path;
    private String message;
    private String error;
    private Map<String, String> validationErrors;
    //private Date createdDate = new Date(System.currentTimeMillis());
    private String createdDate = nowDate();

    // Constructor (Parametreli) => s  m  p
    public ApiResult(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        //createdDate = new Date(System.currentTimeMillis());
    }

    // Constructor (Parametreli) => s e m  p
    public ApiResult(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        //createdDate = new Date(System.currentTimeMillis());
    }

    // Now Date
    private String nowDate() {
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        Date date=new Date();
        return  dateFormat.format(date);
    } //end nowDate() method

} //end class
