package com.hamitmizrak.seniorfullstack1.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

// LOMBOK
@RequiredArgsConstructor // Inject
@Log4j2

// API
@RestController
@CrossOrigin
// Spring error için benim yazdığım class,method
public class ErrorControllerHandleWebRequest implements ErrorController {

    // Injection
    // org.springframework.boot.web.servlet.error.ErrorAttributes
    private final ErrorAttributes errorAttributes;

    // http://localhost:1111/error
    @RequestMapping("/error")
    public ApiResult handleError(WebRequest webRequest){
        return null;
    } //end method

} //end class
