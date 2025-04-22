package com.se370group1.banking_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BankAccounts")
public class BankAccount {
    @Id
    private String accountID;

    private String connectedUserID;
    double balance;

    public BankAccount(String accountID, String connectedUserID, double balance) {
        this.accountID = accountID;
        this.connectedUserID = connectedUserID;
        this.balance = balance;
    }

    public String getAccountNum() {return this.accountID;}
    public String getConnectedUserID() {return this.connectedUserID;}
    public double getCurrentBalance() {return this.balance;}
    
}
