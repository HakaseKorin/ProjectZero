package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private int customerId;
    private String first;
    private String last;
    private List<Account> accountList = new ArrayList<>();

    public void apply(){}
}
