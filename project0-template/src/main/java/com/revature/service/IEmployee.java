package com.revature.service;

import com.revature.models.Customer;

public interface IEmployee {
    void viewAccountInfo(Customer customer);
    void viewAccountBalance(Customer customer);
    void viewUserInfo(Customer customer);
}
