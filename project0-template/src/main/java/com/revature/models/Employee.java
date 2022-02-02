package com.revature.models;

public class Employee extends User{

    public Employee(String first, String last) {
        super(first, last);
        this.setType(UserType.EMPLOYEE);
        this.setEmail(first+"."+last+"@bank.com");
        this.setPassword("password");

    }

    public Employee(int id, String first, String last, String email, String pass, UserType type){
        super(email, pass, first, last, type);
        this.setId(id);
    }
}
