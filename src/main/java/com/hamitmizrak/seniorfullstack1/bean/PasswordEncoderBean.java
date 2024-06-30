package com.hamitmizrak.seniorfullstack1.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderBean {

    @Bean
    public PasswordEncoder getPasswordEncoderMethod() {
        return new BCryptPasswordEncoder();
    }//end method
}//end class
