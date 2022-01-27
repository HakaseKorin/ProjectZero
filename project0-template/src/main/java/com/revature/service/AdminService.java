package com.revature.service;

import com.revature.models.Admin;
import com.revature.models.UserType;

import java.util.Date;

public class AdminService extends EmployeeService{
    public Admin createNewAdmin(String first, String last){
        Admin admin = new Admin(first, last);
        return admin;
    }
}
