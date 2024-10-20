package org.chandima.springsecurityapp.service;

import org.chandima.springsecurityapp.config.SecurityConfig;
import org.chandima.springsecurityapp.model.User;
import org.chandima.springsecurityapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
;

    public User register(User user){

        user.setPassword(encoder.encode(user.getPassword()));

       return userRepository.save(user);
    }

}
