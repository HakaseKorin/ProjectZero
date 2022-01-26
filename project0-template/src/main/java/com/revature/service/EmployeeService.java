package com.revature.service;

import com.revature.models.Customer;
import com.revature.models.Employee;

import java.util.Date;

public class EmployeeService implements IEmployee{
    public Employee createNewEmployee(String first, String last, Date dob){
        Employee employee = new Employee(first,last, dob);
        return employee;
    }

    @Override
    public void viewAccountInfo(Customer customer) {

    }

    @Override
    public void viewAccountBalance(Customer customer) {

    }

    @Override
    public void viewUserInfo(Customer customer) {

    }
}
