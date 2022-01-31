package com.revature.service;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.models.Customer;
import com.revature.models.Order;

public class CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    public boolean createCustomer(String email, String password){
        Customer customer = new Customer(email, password);
        return  customerDao.createCustomer(customer);
    }

    public void createOrder(Customer customer, Order order){}

    public void addToOrder(Customer customer, Order order){}

    public void removeFromOrder(Customer customer, Order order){}

    public void readOrder(Customer customer){}

    public void submitOrder(Customer customer){}
}
