package com.se370group1.banking_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Transactions")
public class Transaction { //stack that holds previous transactions
    @Id
    private int transaction_id;
    
    private String transaction_name;
    private double transaction_amount;

    public String get_transaction_name() {return this.transaction_name;}
    public double get_transaction_amount() {return this.transaction_amount;}
    public void show_transaction_info() {
        System.out.println(this.get_transaction_name() + " " + this.get_transaction_amount());
    }
}
