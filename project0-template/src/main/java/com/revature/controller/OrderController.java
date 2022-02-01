package com.revature.controller;

import com.revature.models.Order;
import io.javalin.http.Context;

public class OrderController {

    public void handleCreateOrder(Context ctx){
        Order order = ctx.bodyAsClass(Order.class);
    }

    public void handleAddToOrder(Context ctx){
        Order order = ctx.bodyAsClass(Order.class);
    }

}
