package com.revature.models;

import com.revature.service.IAccount;

public class Account implements IAccount {
    private int id;
    private int customerId;
    private float balance;


    public Account(float balance, int customerId) {
        this.balance = balance;
        this.customerId = customerId;
    }

    @Override
    public void withdraw(Account account, float amount) {

    }

    @Override
    public void deposit(Account account, float amount) {

    }

    @Override
    public void transfer(Account origin, Account destination) {

    }
}
