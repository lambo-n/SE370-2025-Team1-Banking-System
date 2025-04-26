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

    public TransactionDTO(Transaction transaction) {
        this.transactionID = transaction.getTransactionID();
        this.connectedBankAccount = transaction.getConnectedBankAccountID();
        this.sourceEntity = transaction.getSourceEntity();
        this.details  = transaction.getDetails();
        this.amountDollars = transaction.getAmountDollars();
        this.transactionDate = transaction.getTransactionDate();
    }
    public Transaction toDomainModel() {
        Transaction transaction = new Transaction(this.transactionID, this.connectedBankAccount, this.sourceEntity, this.details, this.amountDollars, this.transactionDate);
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

    public Date getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }
}
