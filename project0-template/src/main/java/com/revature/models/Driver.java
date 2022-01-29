package com.revature.models;

public class Driver extends User {
    private String address;

    public Driver(String email, String password, UserType type, String address) {
        super(email, password, type);
        this.address = address;
    }
}
