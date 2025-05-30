package com.se370group1.banking_system.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se370group1.banking_system.dto.UserDTO;
import com.se370group1.banking_system.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/logInUser")
    public Boolean LogInUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.printf("Passed username: %s\nPassed password: %s\n", username, password);

        try {
            Boolean correctLogin = userService.LogInUser(username, password);
            if (correctLogin) {
                System.out.println("User logged in successfully");

                // Store user information in the session
                session.setAttribute("username", username);
                session.setAttribute("isLoggedIn", true);

                return true;
            } else {
                System.out.println("Incorrect username or password");
                return false;
            }
        } catch (IllegalAccessError illegalAccessError) {
            System.out.println("Major Error");
            System.out.println(illegalAccessError.getMessage());
            return false;
        }
    }
    @GetMapping("/createNewUser")
    public void CreateNewUser(
        @RequestParam String username,
        @RequestParam String password, 
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String email,
        @RequestParam int phoneNum,
        @RequestParam int socialSecurityNum,
        @RequestParam String street,
        @RequestParam String city,
        @RequestParam String state,
        @RequestParam String zip
    ) {
        System.out.println("save new user controller called");
        
        try {
            // Combine address components
            String fullAddress = String.format("%s, %s, %s %s", street, city, state, zip);
            
            // Generate a unique userID (you may want to implement a better ID generation strategy)
            String userID = java.util.UUID.randomUUID().toString();
            
            // Combine first and last name
            String fullName = firstName + " " + lastName;
            
            UserDTO newUser = userService.createNewUser(
                userID, 
                username, 
                password, 
                fullName, 
                email, 
                phoneNum, 
                socialSecurityNum, 
                fullAddress
            );
            
            System.out.printf("username \"%s\" saved\n", newUser.getUsername());
        }
        catch (IllegalAccessError illegalAccessError) {
            System.out.println("Username taken. Please choose a different one.");
        }    
    }
    @GetMapping("/logOutUser")
    public void logOutUser(HttpSession session) {
        session.invalidate(); // Invalidate the session
        System.out.println("User logged out successfully");
    }
    @GetMapping("/sessionStatus")
    public Map<String, Object> sessionStatus(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");

        if (isLoggedIn != null && isLoggedIn) {
            response.put("isLoggedIn", true);
            response.put("username", session.getAttribute("username"));
        } else {
            response.put("isLoggedIn", false);
        }

        return response;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");

        if (isLoggedIn != null && isLoggedIn) {
            return "Welcome to the dashboard, " + session.getAttribute("username") + "!";
        } else {
            throw new IllegalStateException("Unauthorized access. Please log in.");
        }
    }
}
