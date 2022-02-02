package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private int id;
    private List<Account> accountList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String user, String pass) {
        super(user, pass);
        this.setType(UserType.CUSTOMER);
    }

    public Customer(String email, String password, String first, String last, UserType type) {
        super(email, password, first, last, type);
    }

    public Customer(int id, List<Account> account, String first, String last, String email, String pass, UserType type){
        super(email, pass, first, last, type);
        this.setId(id);
        this.setAccountList(account);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addAccount(Account account){
        this.accountList.add(account);
    }
}
