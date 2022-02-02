package com.revature.service;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.Customer;
import com.revature.models.UserType;

public class CustomerService {
    public Customer createNewCustomer(String email, String password, String first, String last, UserType type){
        Customer customer = new Customer(email, password, first, last, type);
        return customer;
    }
}
