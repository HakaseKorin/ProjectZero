package com.revature.models;

import java.util.Date;

public abstract class User {
    private String email;
    private String password;
    private String first;
    private String last;
    private UserType type;
    //access privilege?

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String first, String last, UserType type) {
        this.email = email;
        this.password = password;
        this.first = first;
        this.last = last;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
