package com.se370group1.banking_system.dto;

import java.util.Date;

import com.se370group1.banking_system.model.Transaction;

public class TransactionDTO {
    private String transactionID;
    private String connectedBankAccount;
    private String sourceEntity;
    private String details; //name of transaction, how much, date and time
    private double amountDollars;
    private Date transactionDate;

    public TransactionDTO(String transactionID, String connectedBankAccount, String sourceEntity, String details, double amountDollars, Date transactionDate) {
        this.transactionID = transactionID;
        this.connectedBankAccount = connectedBankAccount;
        this.sourceEntity = sourceEntity;
        this.details = details;
        this.amountDollars = amountDollars;
        this.transactionDate = transactionDate;
    }
    public TransactionDTO(Transaction t) {
        this.transactionID = null;
        this.connectedBankAccount = null;
        this.sourceEntity = null;
        this.details  = null;
        this.amountDollars = 0.0;
        this.transactionDate = null;
    }
    public Transaction toDomainModel() {
        Transaction transaction = new Transaction(this.transactionID, this.connectedBankAccount, this.sourceEntity, this.details, this.amountDollars, this.transactionDate);
        return transaction;
    }

    public TransactionDTO geTransactionDTO() { return this; }
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

    public Date getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }
}
