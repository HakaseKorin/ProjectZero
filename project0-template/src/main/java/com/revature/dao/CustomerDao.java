package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.Order;

import java.sql.Date;
import java.util.List;

public interface CustomerDao {

    boolean createCustomer(Customer customer);
    List<Order> getCustomerOrderById(int customerId, Date orderDate);
}
