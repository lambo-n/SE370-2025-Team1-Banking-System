package com.se370group1.banking_system.model;

public class Transaction { //stack that holds previous transactions
    private String transaction_name;
    private double transaction_amount;

    public String get_transaction_name() {return this.transaction_name;}
    public double get_transaction_amount() {return this.transaction_amount;}
    public void show_transaction_info() {
        System.out.println(this.get_transaction_name() + " " + this.get_transaction_amount());
    }
}
