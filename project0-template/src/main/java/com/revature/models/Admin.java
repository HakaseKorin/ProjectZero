package com.revature.models;

import java.util.Date;

public class Admin extends User{
    private int AdminId;

    public Admin(String first, String last, Date dob) {
        super(first, last, dob);
    }
}
