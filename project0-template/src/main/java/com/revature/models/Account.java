package com.revature.models;

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

    public Account() {

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

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
