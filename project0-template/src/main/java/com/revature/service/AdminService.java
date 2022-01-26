package com.revature.service;

import com.revature.models.Admin;

import java.util.Date;

public class AdminService extends EmployeeService{
    public Admin createNewAdmin(String first, String last, Date dob){
        Admin admin = new Admin(first, last, dob);
        return admin;
    }
}
