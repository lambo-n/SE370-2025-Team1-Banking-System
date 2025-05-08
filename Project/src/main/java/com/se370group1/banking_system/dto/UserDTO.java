package com.se370group1.banking_system.dto;

import com.se370group1.banking_system.model.User;

public class UserDTO {
    private String userID;
    private String username;
    private String password;
    private String name;
    private String email;
    private int phoneNum;
    private int socialSecurityNum;
    private String address;

    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNum = user.getPhoneNum();
        this.socialSecurityNum = user.getSocialSecurityNum();
        this.address = user.getAddress();
    }

    public User toDomainModel() {
        User user = new User(this.userID, this.username, this.password, this.name, this.email, this.phoneNum, this.socialSecurityNum, this.address);
        return user;
    }

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getPhoneNum() { return phoneNum; }
    public void setPhoneNum(int phoneNum) { this.phoneNum = phoneNum; }

    public int getSocialSecurityNum() { return socialSecurityNum; }
    public void setSocialSecurityNum(int socialSecurityNum) { this.socialSecurityNum = socialSecurityNum; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
