package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private List<Order> cart;

    public Customer() {
    }

    public Customer(String email, String password) {
        super(email, password);
        this.setType(UserType.CUSTOMER);
        this.cart = new ArrayList<>();
    }

    public void addOrder(Order order){
        this.cart.add(order);
    }

    public void purchaseOrder(){
        this.cart = new ArrayList<>();
    }
}
