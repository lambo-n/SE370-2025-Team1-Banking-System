package com.se370group1.banking_system.dto;

import org.springframework.stereotype.Component;

import com.se370group1.banking_system.model.User;

public class UserDTO {
    private String userID;
    private String username;
    private String password;

    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public User toDomainModel() {
        User user = new User(this.userID, this.username, this.password);
        return user;
    }

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
