package com.se370group1.banking_system.dto;

import com.se370group1.banking_system.model.BankAccount;

public class BankAccountDTO {
    private String bankAccountID;
    private String bankAccountName;
    private String connectedUserID;
    private double balance;

    public BankAccountDTO(BankAccount bankAccount) {
        this.bankAccountID = bankAccount.getBankAccountID();
        this.bankAccountName = bankAccount.getBankAccountName();
        this.connectedUserID = bankAccount.getConnectedUserID();
        this.balance = bankAccount.getCurrentBalance();
    }

    public BankAccount toDomainModel() {
        BankAccount bankAccount = new BankAccount(this.bankAccountID, this.bankAccountName, this.connectedUserID, this.balance);
        return bankAccount;
    }

    public String getBankAccountID() { return bankAccountID; }
    public void setBankAccountID(String bankAccountID) { this.bankAccountID = bankAccountID; }

    public String getBankAccountName() { return bankAccountName; }
    public void setBankAccountName(String bankAccountName) { this.bankAccountName = bankAccountName; }

    public String getConnectedUserID() { return connectedUserID; }
    public void setConnectedUserID(String connectedUserID) { this.connectedUserID = connectedUserID; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }


}
