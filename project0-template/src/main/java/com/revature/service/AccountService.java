package com.revature.service;

import com.revature.models.Account;
import com.revature.models.AccountType;

public class AccountService{
    public Account createNewAccount(float balance, int id, AccountType type){
        Account account = new Account(balance, id, type);
        return account;
    }

    public void withdraw(Account account, float amount) {
        //case for overdrafting
        account.setBalance(account.getBalance()-amount);
    }

    public void deposit(Account account, float amount) {
        account.setBalance(account.getBalance()+amount);
    }

    public void transfer(Account origin, Account destination, float amount) {
        //check for when two accounts belong to their proper users
        withdraw(origin,amount);
        deposit(destination,amount);
    }
}
