package com.revature.service;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.UserType;

import java.util.Date;

public class EmployeeService implements IEmployee{
    public Employee createNewEmployee(String first, String last){
        Employee employee = new Employee(first,last);
        employee.setPassword("password");
        return employee;
    }
        ////method to check access validity
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
