package com.revature.service;

import com.revature.models.Account;
import com.revature.models.AccountType;

public class AccountService implements IAccount {
    public Account createNewAccount(float balance, int id, AccountType type){
        Account account = new Account(balance, id, type);
        return account;
    }

    @Override
    public void withdraw(Account account, float amount) {
        //case for overdrafting
        account.setBalance(account.getBalance()-amount);
    }

    @Override
    public void deposit(Account account, float amount) {
        account.setBalance(account.getBalance()+amount);
    }

    @Override
    public void transfer(Account origin, Account destination, float amount) {
        //check for when two accounts belong to their proper users
        withdraw(origin,amount);
        deposit(destination,amount);
    }
}
