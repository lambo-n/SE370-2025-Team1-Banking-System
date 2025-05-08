package com.se370group1.banking_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
    @Id
    private String userID;

    private String username;
    private String password;
    private String name;
    private String email;
    private int phoneNum;
    private int socialSecurityNum;
    private String address;

    public User(String userID, String username, String password, String name, String email, int phoneNum, int socialSecurityNum, String address) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.socialSecurityNum = socialSecurityNum;
        this.address = address;
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
