package com.revature.service;

import com.revature.models.Account;

public class AccountService implements IAccount {
    public Account createNewAccount(float balance, int id){
        Account account = new Account(balance, id);
        return account;
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
