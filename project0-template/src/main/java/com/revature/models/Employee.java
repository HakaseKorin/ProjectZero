package com.revature.models;

import java.util.Date;

public class Employee extends User{
    private int employeeId;
    public Employee(String first, String last, Date dob) {
        super(first, last, dob);
    }
}
