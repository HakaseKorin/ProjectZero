package com.revature.models;

import com.revature.service.IAccount;

public class Account implements IAccount {
    private float balance;
    public int customerId;

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
