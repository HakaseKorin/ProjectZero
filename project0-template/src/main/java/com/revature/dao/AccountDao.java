package com.revature.dao;

import com.revature.models.Account;

public interface AccountDao {
    Account getById(int id);
    boolean createAccount(Account account);
    boolean update(Account account);
}
