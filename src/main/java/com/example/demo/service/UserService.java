package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
