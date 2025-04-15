package com.se370group1.banking_system.model;

import java.util.Stack;

public class BankAccount {
    //account number, transactions, current balance
    private int account_number;
    //private Stack<Transaction> transactions;
    double current_balance;

    public int getAccountNum() {return this.account_number;}
    public double getCurrentBalance() {return this.current_balance;}
    
}
