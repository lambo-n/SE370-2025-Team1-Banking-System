package com.se370group1.banking_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BankAccounts")
public class BankAccount {
    @Id
    private final String bankAccountID;

    private final String bankAccountName;
    private final String connectedUserID;
    private double balance;

    public BankAccount(String bankAccountID, String bankAccountName, String connectedUserID, double balance) {
        this.bankAccountID = bankAccountID;
        this.bankAccountName = bankAccountName;
        this.connectedUserID = connectedUserID;
        this.balance = balance;
    }

    public String getBankAccountID() {return this.bankAccountID;}
    public String getBankAccountName() {return this.bankAccountName;}
    public String getConnectedUserID() {return this.connectedUserID;}
    public double getCurrentBalance() {return this.balance;}
    
}
