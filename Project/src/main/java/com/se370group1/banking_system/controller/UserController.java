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

    @GetMapping("/createNewUser")
    public void CreateNewUser(){
        System.out.println("save new user controller called");
        
        try 
        {
            UserDTO newUser = userService.createNewUser("0", "test0", "testpass0");

            //user successfully created, will not print if userService throws exception
            System.out.printf("username     \"%s\" saved\n", newUser.getUsername());
        }
        catch (IllegalAccessError illegalAccessError)
        {
            System.out.println("Username taken. Please choose a different one.");
        }    
    }

    @GetMapping("/logInUser")
    public void LogInUser() {
        System.out.println("sign in user called");
    }
}
