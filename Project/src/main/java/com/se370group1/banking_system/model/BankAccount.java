package com.se370group1.banking_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BankAccounts")
public class BankAccount {
    @Id
    private String accountID;

    private String connectedUserID;
    double current_balance;

    public String getAccountNum() {return this.accountID;}
    public String getConnectedUserID() {return this.connectedUserID;}
    public double getCurrentBalance() {return this.current_balance;}
    
}
