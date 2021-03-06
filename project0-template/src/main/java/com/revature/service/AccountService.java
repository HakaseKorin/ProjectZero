package com.revature.service;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.models.Account;
import com.revature.models.AccountType;

public class AccountService{

    private AccountDao accountDao = new AccountDaoImpl();

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
        withdraw(origin,amount);
        deposit(destination,amount);
    }

    public Account getById(int id) {
        return accountDao.getById(id);
    }

    public boolean update(Account account) {
        return accountDao.update(account);
    }
}
