package com.revature;

import com.revature.dao.UserDao;
import com.revature.models.Customer;
import com.revature.service.CustomerService;

public class BankManagementDriver {

    public static void main(String[] args){

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.createNewCustomer("JaneDoe@email.com", "password123");

        UserDao userDao = new UserDao();
        userDao.createUser(customer);
    }

}
