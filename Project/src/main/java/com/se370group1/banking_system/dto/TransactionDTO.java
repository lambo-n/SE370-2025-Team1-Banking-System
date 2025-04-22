package com.se370group1.banking_system.dto;

import com.se370group1.banking_system.model.Transaction;

public class TransactionDTO {
    private String transactionID;
    private String connectedBankAccount;
    private String sourceEntity;
    private String details;
    private double amountDollars;

    public TransactionDTO(String transactionID, String connectedBankAccount, String sourceEntity, String details, double amountDollars) {
        this.transactionID = transactionID;
        this.connectedBankAccount = connectedBankAccount;
        this.sourceEntity = sourceEntity;
        this.details = details;
        this.amountDollars = amountDollars;
    }

    public Transaction toDomainModel() {
        Transaction transaction = new Transaction(this.transactionID, this.connectedBankAccount, this.sourceEntity, this.details, this.amountDollars);
        return transaction;
    }

    public String getTransactionID() { return transactionID; }
    public void setTransactionID(String transactionID) { this.transactionID = transactionID; }

    public String getConnectedBankAccount() { return connectedBankAccount; }
    public void setConnectedBankAccount(String connectedBankAccount) { this.connectedBankAccount = connectedBankAccount; }

    public String getSourceEntity() { return sourceEntity; }
    public void setSourceEntity(String sourceEntity) { this.sourceEntity = sourceEntity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public double getAmountDollars() { return amountDollars; }
    public void setAmountDollars(double amountDollars) { this.amountDollars = amountDollars; }
}
