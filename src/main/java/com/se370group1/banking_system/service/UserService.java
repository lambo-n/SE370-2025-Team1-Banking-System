package com.se370group1.banking_system.service;

import org.springframework.stereotype.Service;
import com.se370group1.banking_system.model.User;

@Service
public class UserService {
    private final User user;

    public UserService(User user){
        this.user = user;
    }

    public String ChangeBackgroundColor() {
        int randomColor = (int) (Math.random() * 16777215);
        String hexColor = Integer.toHexString(randomColor);
        System.out.println("Generated Hex Color: #" + hexColor);
        return hexColor;
    }
}
