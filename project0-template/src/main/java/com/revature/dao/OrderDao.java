package com.revature.dao;

import com.revature.models.Order;

public interface OrderDao {
    int createOrderId(int customerId);
    Order getMostRecentOrder(int customerId);
    boolean addToOrder(Order order);
}
