// 1.ADIM
// Spring Security: Şimdilik dahil etme, çünkü Bcrypted kullancağım ancak Spring security için gerekli kütüphaneleri dahil
// Buradaki exclude ne zaman kapatmam gerekiyor ? cevap: Spring Security ile çalıştığımız zaman kapat
/*@SpringBootApplication(exclude = {
        //SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)*/

// Spring Security kullandığım zaman => @SpringBootApplication


// 2.ADIM
/*devtools: otomatik sistemi compiler etmek içindir-->
        <!--devtools: ancak Spring security kapatabilirsin-->
        <!-- <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
        <scope>runtime</scope>
        </dependency>
  */



// 3.ADIM (Default =>Login )
// Username: user
// Password: 9be827ae-4d3b-4b0f-b37a-a4666e1ce59f

// 4.ADIM (application.properties)
/*
### Spring Security  #################################################################
spring.command.line.rules.superadmin.nickname=superadmin
spring.command.line.rules.superadmin.name=Hamit
spring.command.line.rules.superadmin.surname=M?zrak
spring.command.line.rules.superadmin.email=hamitmizrak@gmail.com
spring.command.line.rules.superadmin.password=root
spring.command.line.rules.superadmin.roles=SUPER_ADMIN
*/

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package com.hamitmizrak.seniorfullstack1.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// LOMBOK
@RequiredArgsConstructor

// SECURITY
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Super Admin
    private String user;
    private String password;
    private String roles;



}
