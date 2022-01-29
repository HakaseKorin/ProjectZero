package com.revature.models;

public class Admin extends User{

    public Admin(String first, String last) {
        super();
        this.setFirst(first);
        this.setLast(last);
        this.setEmail(first + "." + last + "@Admin.com");
        this.setPassword("admin");
        this.setType(UserType.ADMIN);
    }
}
