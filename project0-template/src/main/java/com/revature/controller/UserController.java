package com.revature.controller;

import com.revature.models.Customer;
import com.revature.models.Driver;
import com.revature.models.User;
import com.revature.service.UserService;
import io.javalin.http.Context;

import java.awt.dnd.DragGestureEvent;
import java.util.List;

public class UserController {

    UserService userService = new UserService();

    public void handleGetOne(Context ctx){
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        User user = userService.getById(id);
        ctx.json(user);
    }

    public void handleCreateCustomer(Context ctx){
        Customer customer = ctx.bodyAsClass(Customer.class);
        boolean success = userService.createCustomer(customer);

        if(success)
            ctx.status(201);
        ctx.status(400);
    }

    public void handleCreateDriver(Context ctx){
        Driver driver = ctx.bodyAsClass(Driver.class);
        boolean success = userService.createDriver(driver);

        if(success)
            ctx.status(201);
        ctx.status(400);
    }

    public void handleGetAllDrivers(Context ctx){
        List<Driver> drivers = userService.getAllDriver();
        ctx.json(drivers);
    }


}
