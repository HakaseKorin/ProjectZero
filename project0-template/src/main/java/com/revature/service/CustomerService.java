package com.revature.service;

import com.revature.models.Customer;

public class CustomerService {
    public Customer createNewCustomer(String user, String pass){
        Customer customer = new Customer(user, pass);
        return customer;
    }
}
