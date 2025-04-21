package com.se370group1.banking_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se370group1.banking_system.dto.UserDTO;
import com.se370group1.banking_system.model.User;
import com.se370group1.banking_system.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDTO createNewUser(String userID, String username, String password) {
        
        Boolean userAlreadyExists = CheckIfUserExists(username);
        
        if (userAlreadyExists)
        {
            throw new IllegalAccessError("Username already exists");
        }
        else
        {
            User newUser = new User(userID, username, password);
            userRepository.save(newUser);
    
            UserDTO savedUser = new UserDTO(newUser);
            return savedUser;
        }
    }

    public Boolean CheckIfUserExists(String username)
    {
        List<User> existingUsername = userRepository.findByUsername(username);
        Boolean userExists = !existingUsername.isEmpty();
        return userExists;
    }

    public String ChangeBackgroundColor() {
        int randomColor = (int) (Math.random() * 16777215);
        String hexColor = Integer.toHexString(randomColor);
        return hexColor;    
    }

    
}
