package com.revature.service;

import com.revature.models.MenuItem;
import com.revature.models.Order;

public class OrderService {

    public Order createOrder(int id, MenuItem item, int quantity){
        Order order = new Order(id, item, quantity);
        return order;
    }
}
