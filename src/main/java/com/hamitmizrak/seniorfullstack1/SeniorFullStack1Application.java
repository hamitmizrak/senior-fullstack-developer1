package com.hamitmizrak.seniorfullstack1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Mongo aktif etmek ici
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
//@EntityScan(basePackages = "com.hamitmizrak.seniorfullstack1.data.entity") //Entity bulamadığı zaman
//@EnableJpaRepositories(basePackages = "com.hamitmizrak.seniorfullstack1.data.repository") //Repository bulamadığı zaman
//@ComponentScan("com")

// Spring Cache aktif etmek gerekiyor.
// @EnableCaching

// Auditing Aktif etmek
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")

// Spring Security: Şimdilik dahil etme, çünkü Bcrypted kullancağım ancak Spring security için gerekli kütüphaneleri dahil
// Buradaki exclude ne zaman kapatmam gerekiyor ? cevap: Spring Security ile çalıştığımız zaman kapat
/*@SpringBootApplication(exclude = {
        //SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)*/

// Apache Tomcat için: extends SpringBootServletInitializer
@SpringBootApplication
public class SeniorFullStack1Application {

 /*
 @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    }
 */

    // PSVM
    public static void main(String[] args) {
        // devtools active isActive
        // System.setProperty("spring.devtools.restart.enabled","true");

        // PORT Ayarlamak
        /*
        SpringApplication app = new SpringApplication(TurgutUniversitySpringAllInOneApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
         */

        // JOptional pane aktif etmek
        System.setProperty("java.awt.headless", "false");

        // Main
        SpringApplication.run(SeniorFullStack1Application.class, args);
    } // end PSVM

} // end class
