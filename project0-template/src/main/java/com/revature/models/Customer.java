package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private List<Order> cart;

    public Customer(String email, String password, UserType type) {
        super(email, password, type);
        this.cart = new ArrayList<>();
    }

    public void addOrder(Order order){
        this.cart.add(order);
    }

    public void purchaseOrder(){
        this.cart = new ArrayList<>();
    }
}
