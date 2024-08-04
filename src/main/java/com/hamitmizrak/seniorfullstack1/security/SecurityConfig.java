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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

// LOMBOK
@RequiredArgsConstructor

// SECURITY
@Configuration // @Bean için eklenir
@EnableWebSecurity // Spring Security aktifleştirmek içindir
public class SecurityConfig {

    // username: hamitmizrak@gmail.com
    // password: root

    // VALUE(application.properties)
    // Super Admin (application.properties veri almak için)
    // import org.springframework.beans.factory.annotation.Value;
    // hamitmizrak@gmail.com
    @Value("${spring.security.superadmin.email}")
    private String email;

    // root
    @Value("${spring.security.superadmin.password}")
    private String password;

    @Value("${spring.security.superadmin.roles}")
    private String roles;

    // PASSWORD ENCODER
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //end PasswordEncoder

    // WEB DOSYALARINA ERİŞİM (CS,JS,IMAGE)
    // http://localhost:4444/swagger-ui/index.html
    // http://localhost:4444/h2-console
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring() //lambda expression
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**"))
                .requestMatchers(new AntPathRequestMatcher("/favicon.ico"))
                .requestMatchers(new AntPathRequestMatcher("/html/**"))
                .requestMatchers(new AntPathRequestMatcher("/css/**"))
                .requestMatchers(new AntPathRequestMatcher("/js/**"))
                .requestMatchers(new AntPathRequestMatcher("/img/**"))
                .requestMatchers(new AntPathRequestMatcher("/lib/**"));
    } //end WebSecurityCustomizer

    // InMemory => Database üzerinden Authentication olmadan kullandığımız bir metottur
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails admin = User
                .withDefaultPasswordEncoder()
                //.username("admin")
                .username(email)
                //.password("root")
                .password(password)
                .roles("ROLES_ADMIN")
                .build();

        UserDetails writer = User
                .withDefaultPasswordEncoder()
                .username("writer")
                .password("root")
                .roles("ROLES_ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin, writer);
    } //end InMemoryUserDetailsManager


    // SECURTIY FILTER CHAIN
    // Eğer aşağıda verdiğim sayfaları eklemezsem bu hatayı alırım  => HTTP ERROR 403
    // Access to localhost was deniedYou don't have authorization to view this page. HTTP ERROR 403
    // Failed to load remote configuration: login olmalısınız
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
        // CSRF
        httpSecurity.csrf(AbstractHttpConfigurer::disable); //method Referances

        // Web Page
        httpSecurity.authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(new MvcRequestMatcher(introspector, "/")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index.html")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index.htm")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/login")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/admin")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/logout")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/swagger-ui/**")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "//h2-console/**")).permitAll()
                                .anyRequest().authenticated()) //end httpSecurity

                // Http Form İzin Ver
                .httpBasic(Customizer.withDefaults())

                        // Page Form İzin Ver
                        // Not: Eğer formLogin seçerseniz Postman uygulamasında Authentication, Authorization işlemlerinde sıkıntı çaıkartacak
                        //.formLogin(Customizer.withDefaults());

                // Session
                // Eğer session olmuş bir kullanıcı varsa logout sonunda güvenli çıkış yapılsın
                .logout().logoutUrl("/logout").invalidateHttpSession(true);
        return httpSecurity.build();
    } //end SecurityFilterChain

} //end SecurityConfig
