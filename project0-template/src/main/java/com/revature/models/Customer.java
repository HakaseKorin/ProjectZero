package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private int customerId;
    private List<Account> accountList = new ArrayList<>();

    public Customer(String userName, String password) {
        super(userName, password);
    }

    //public void apply(){}
}
