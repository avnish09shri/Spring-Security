package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /*return http.authorizeHttpRequests()
                .requestMatchers("/myAccount","myBalance","myCards","myLoans").authenticated()
                .requestMatchers("/notices","/contact").permitAll()
                .and().formLogin().and().httpBasic().and().build();*/

        return http.authorizeHttpRequests((requests) -> requests
               .requestMatchers("/myAccount","myBalance","myCards","myLoans").authenticated()
               .requestMatchers("/notices","/contact").permitAll())
               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults()).build();
    }

}
