package com.hamitmizrak.seniorfullstack1.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LOMBOK
//@RequiredArgsConstructor // Inject
@Log4j2

// API
@RestController
@CrossOrigin
// Spring error için benim yazdığım class,method
//@Component
public class ErrorControllerHandleWebRequest implements ErrorController {
    // ErrorController
    // ErrorAttributes
    // WebRequest

    // Injection
    // org.springframework.boot.web.servlet.error.ErrorAttributes

    private final ErrorAttributes errorAttributes;
    @Autowired
    public ErrorControllerHandleWebRequest(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    //private final ErrorAttributes errorAttributes;

    // Field: s m p v
    private Integer status;
    private String message;
    private String path;
    private Map<String, String> validationErrors;

    // ApiResult (Global)
    private ApiResult apiResult;

    // http://localhost:4444/error
    @GetMapping("/error")
    public ApiResult handleError(WebRequest webRequest) {

        // Spring Boot Version>=2.3
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS)
                ); //end Attributes

        status=(Integer) attributes.get("status");
        //message=attributes.get("message").toString();
        message=(String)attributes.get("message");
        path=(String)attributes.get("path");

        // Api Result
        // Constructor (Parametreli) => s  m  p
        // public ApiResult(Integer status, String message, String path)
        apiResult=new ApiResult(status,message,path);

        // Eğer Spring'ten gelen Hata varsa bunu yaz
        if(attributes.containsKey("errors")) {

            // List Create
            List<FieldError> fieldErrorList=(List<FieldError>) attributes.get("error");

            // ValidationError Instance
            validationErrors=new HashMap<>();

            // Bütün Hataları döngü ile dönerek yakala
            for(FieldError fieldError:fieldErrorList) {
                validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }

            // Hatalarımızı yazdığımız ApiResult'ta Set et.
            apiResult.setValidationErrors(validationErrors);
            System.out.println(validationErrors);
        }
        return apiResult;
    } //end method

} //end class
