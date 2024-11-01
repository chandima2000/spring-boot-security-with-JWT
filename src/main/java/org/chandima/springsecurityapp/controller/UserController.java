package org.chandima.springsecurityapp.controller;

import org.chandima.springsecurityapp.model.User;
import org.chandima.springsecurityapp.service.JwtService;
import org.chandima.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public User register(@RequestBody User user){

        return userService.register(user);

    }

    @PostMapping("login")
    public String login(@RequestBody User user){

        // Check the username and password is correct or not
        Authentication authentication = authenticationManager
                .authenticate( new UsernamePasswordAuthenticationToken(user.getUsername(),
                        user.getPassword()));


        // If username and password is correct, then generate the token
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        else
            return "Login Failed";

    }

}
