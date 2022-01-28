package com.revature.models;

import com.revature.service.IAccount;

public class Account {
    private int id;
    private int customerId;
    private AccountType type;
    private float balance;

    public Account(float balance, int customerId, AccountType type) {
        this.balance = balance;
        this.customerId = customerId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
