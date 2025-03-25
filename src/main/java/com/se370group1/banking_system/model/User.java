package com.se370group1.banking_system.model;

import org.springframework.stereotype.Component;

import com.se370group1.banking_system.repository.UserRepository;

@Component
public class User {
    private final UserRepository userRepository;

    public User(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
