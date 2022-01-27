package com.revature.service;

import com.revature.models.Account;

public interface IAccount {
    void withdraw(Account account, float amount);
    void deposit(Account account, float amount);
    void transfer(Account origin, Account destination, float amount);
}
