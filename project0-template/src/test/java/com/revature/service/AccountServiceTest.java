package com.revature.service;

import com.revature.models.Account;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {


    @Test
    void withdraw() {
        AccountService accountService = new AccountService();
        Account account = new Account();
        account.setBalance(1000.00f);
        accountService.withdraw(account, 250.00f);

        assertEquals(account.getBalance(),750.00f);
    }

    @Test
    void deposit() {
        AccountService accountService = new AccountService();
        Account account = new Account();
        account.setBalance(1000.00f);
        accountService.deposit(account,250.00f);

        assertEquals(account.getBalance(), 1250.00f);
    }

    @Test
    void transfer() {
        AccountService accountService = new AccountService();
        Account origin = new Account();
        origin.setBalance(1000.00f);
        Account destination = new Account();
        destination.setBalance(0.00f);

        accountService.transfer(origin,destination, 250.00f);

        assertEquals(origin.getBalance(),750.00f);
        assertEquals(destination.getBalance(),250.00f);
    }

    @Test
    void getById() {
        int id = 1;
        AccountService accountService = new AccountService();
        Account account = accountService.getById(id);
    }

    @Test
    void update() {
    }
}