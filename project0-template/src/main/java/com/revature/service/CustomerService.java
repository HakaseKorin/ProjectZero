package com.revature.service;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.Customer;
import com.revature.models.UserType;

public class CustomerService {
    public Customer createNewCustomer(String user, String pass){
        Customer customer = new Customer(user, pass);
        return customer;
    }
}
