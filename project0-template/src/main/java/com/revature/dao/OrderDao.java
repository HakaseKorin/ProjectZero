package com.revature.dao;

import com.revature.models.Order;

import java.util.List;

public interface OrderDao {
    int createOrderId(int customerId);
    Order getMostRecentOrder(int customerId);
    boolean addToOrder(Order order);
    List<Order> getOrderById(int id);
}
