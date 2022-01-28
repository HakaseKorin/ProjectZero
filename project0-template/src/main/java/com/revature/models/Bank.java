package com.revature.models;

import java.util.List;

public class Bank {
    private List<Customer> customerList;
    private String name;
    private String code;
    private String address;
    private int branchNumber;

    public Bank(List<Customer> customerList, String name, String code, String address, int branchNumber) {
        this.customerList = customerList;
        this.name = name;
        this.code = code;
        this.address = address;
        this.branchNumber = branchNumber;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }
}
