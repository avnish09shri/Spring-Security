package com.springsecurity.config;

import com.springsecurity.filter.CSRFCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler requestAttributeHandler=new CsrfTokenRequestAttributeHandler();
        requestAttributeHandler.setCsrfRequestAttributeName("_csrf");

         http.securityContext().requireExplicitSave(false)
                         .and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)).
                 cors().configurationSource(new CorsConfigurationSource() {
             @Override
             public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                 CorsConfiguration configuration=new CorsConfiguration();
                 configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                 configuration.setAllowedMethods(Collections.singletonList("*"));
                 configuration.setAllowCredentials(true);
                 configuration.setAllowedHeaders(Collections.singletonList("*"));
                 configuration.setMaxAge(3600L);
                 return configuration;
             }
         })
                 .and()
                 .csrf((csrf -> csrf.
                         csrfTokenRequestHandler(requestAttributeHandler).
                         ignoringRequestMatchers("/contact","/register")
                         .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())))
                 .addFilterAfter(new CSRFCookieFilter(), BasicAuthenticationFilter.class)
                 .authorizeHttpRequests((requests) -> requests.
                         requestMatchers("/myAccount","myBalance","myCards","myLoans","/user")
                         .authenticated().requestMatchers("/notices","/contact","/register").
                         permitAll())
                 .formLogin(Customizer.withDefaults())
                 .httpBasic(Customizer.withDefaults());

         return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
