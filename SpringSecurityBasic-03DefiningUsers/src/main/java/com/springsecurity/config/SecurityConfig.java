package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(csrf-> csrf.disable()).authorizeHttpRequests((requests) -> requests
               .requestMatchers("/myAccount","myBalance","myCards","myLoans").authenticated()
               .requestMatchers("/notices","/contact","/user/**").permitAll())
               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults()).build();
    }

    /*@Bean             //Approach 1
    public InMemoryUserDetailsManager userDetailsService(){

        UserDetails admin= User.withDefaultPasswordEncoder().username("admin").password("12345")
                .authorities("admin").build();

        UserDetails user=User.withDefaultPasswordEncoder().username("user").password("12345")
                .authorities("read").build();

        return new InMemoryUserDetailsManager(admin, user);
    }*//*

    @Bean            //Approach 2
    public InMemoryUserDetailsManager userDetailsService(){

        InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
        UserDetails admin=User.withUsername("admin").password("12345").authorities("admin").build();
        UserDetails user=User.withUsername("user").password("12345").authorities("admin").build();

        inMemoryUserDetailsManager.createUser(admin);
        inMemoryUserDetailsManager.createUser(user);

        return  inMemoryUserDetailsManager;
    }*/

    /*@Bean            //using jdbcuserdetailsmanager
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
