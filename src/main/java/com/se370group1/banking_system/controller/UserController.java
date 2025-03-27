package com.se370group1.banking_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.dto.UserDTO;
import com.se370group1.banking_system.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/changeColor")
    public String RequestColorChange(){
        return userService.ChangeBackgroundColor();
    }

    @GetMapping("/saveNewUser")
    public void SaveNewUser(){
        System.out.println("controller called");
        UserDTO newUser = userService.saveNewUser("1", "test", "password");
        System.out.println(newUser.getUsername() + " saved");
    }
}
