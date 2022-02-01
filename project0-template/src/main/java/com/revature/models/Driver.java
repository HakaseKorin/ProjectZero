package com.revature.models;

public class Driver extends User {
    private String address;
    private boolean isAvaliable;

    public Driver() {
    }

    public Driver(String email, String password, String first, String last, String address) {
        super(email, password);
        this.setFirst(first);
        this.setLast(last);
        this.setType(UserType.DRIVER);
        this.address = address;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
