package com.revature.service;

import com.revature.models.Bank;
import com.revature.models.Customer;

import java.util.List;

public class BankService {

    public Bank createBank(List<Customer> customerList, String name, String code, String address, int branchNumber){
        Bank bank = new Bank(customerList, name, code, address, branchNumber);
        return bank;
    }
}
