package com.revature.service;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.UserType;

public class CustomerService {
    public Customer createNewCustomer(String user, String pass){
        Customer customer = new Customer(user, pass);
        return customer;
    }

    public boolean applyNewAccount(Customer customer, float balance){
        //must be approved first?

        Account account = new Account(balance, customer.getId());
        customer.addAccount(account);
        return true;
    }
}
