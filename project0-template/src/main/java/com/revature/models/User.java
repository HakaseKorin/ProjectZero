package com.revature.models;

import java.util.Date;

public abstract class User {
    private String userName;
    private String password;
    private String first;
    private String last;
    private Date dob;
    private UserType type;
    //access privilege?

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String first, String last, Date dob) {
        this.first = first;
        this.last = last;
        this.dob = dob;
    }

    public User(String userName, String password, String first, String last) {
        this.userName = userName;
        this.password = password;
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public Date getDob() {
        return dob;
    }
}
