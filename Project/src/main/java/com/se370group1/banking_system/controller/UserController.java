package com.se370group1.banking_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/logInUser")
    public Boolean LogInUser(@RequestParam String username, @RequestParam String password){
        System.out.printf("Passed username: %s\nPassed password: %s\n", username, password);

        try 
        {
            Boolean correctLogin = userService.LogInUser(username, password);
            if (correctLogin)
            {
                System.out.println("User logged in successfully");
                return true;
            }
            else
            {
                System.out.println("Incorrect username or password");
                return false;
            }
        }
        catch (IllegalAccessError illegalAccessError)
        {
            //catch user already exists error
            System.out.println(illegalAccessError.getMessage());
            return false;
        }
    }
    @GetMapping("/createNewUser")
    public void CreateNewUser(){
        System.out.println("save new user controller called");
        
        try 
        {
            //TODO: add parameters for CreateNewUser() above, make it so that those arguments are the ones used in the createNewUser() method in userService
            //attempt new user creation 
            UserDTO newUser = userService.createNewUser("0", "test0", "testpass0");

            //user successfully created, will not print if userService throws exception
            System.out.printf("username     \"%s\" saved\n", newUser.getUsername());
        }
        catch (IllegalAccessError illegalAccessError)
        {
            //catch user already exists error
            System.out.println("Username taken. Please choose a different one.");
        }    
    }
}
