package com.revature.models;

public class Driver extends User {
    private String address;

    public Driver(String email, String password, String first, String last, String address) {
        super(email, password);
        this.setFirst(first);
        this.setLast(last);
        this.setType(UserType.DRIVER);
        this.address = address;
    }
}
