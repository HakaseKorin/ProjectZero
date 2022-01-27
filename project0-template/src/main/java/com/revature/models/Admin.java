package com.revature.models;

import java.util.Date;

public class Admin extends User{
    private int id;

    public Admin(String first, String last) {
        super(first, last);
        this.setType(UserType.ADMIN);
        this.setEmail(first+"."+last+"@BankAdmin.com");
        this.setPassword("password");
    }

    public Admin(int id, String user, String pass, String first, String last, UserType type){
        super(user, pass, first, last, type);
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
