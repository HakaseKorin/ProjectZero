package com.revature.dao;

import com.revature.models.Order;

public interface OrderDao {
    boolean createOrder(Order order, int customerId);
}
