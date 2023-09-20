package com.springsecurity.config;


import com.springsecurity.exception.CustomerNotFoundException;
import com.springsecurity.model.Customer;
import com.springsecurity.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JPASecurityConfigUserDetails implements UserDetailsService {

    private CustomerRepository customerRepository;

    public JPASecurityConfigUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities=new ArrayList<>();
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new CustomerNotFoundException(email));
        authorities.add(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getEmail(), customer.getPassword(), authorities);

    }
}
