package com.cynthia.girinka.service;

import com.cynthia.girinka.model.User;
import com.cynthia.girinka.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
