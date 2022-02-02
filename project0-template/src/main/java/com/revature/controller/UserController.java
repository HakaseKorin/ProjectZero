package com.revature.controller;

import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.service.UserService;
import io.javalin.http.Context;

import java.util.List;

public class UserController {

    private UserService userService = new UserService();

    public void handleCreateUser(Context ctx){
        Customer user = ctx.bodyAsClass(Customer.class);
        boolean success = userService.createUser(user);

        if(success)
            ctx.status(201);
        else
            ctx.status(400);
    }

    public void handleGetAll(Context ctx){
        List<User> users = userService.getAll();
        ctx.json(users);
    }

    public void handleGetOne(Context ctx){
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        User user = userService.getById(id);
        ctx.json(user);
    }

    public void handleUpdate(Context ctx){
        String idParam = ctx.pathParam("id");
        User updatedUser = ctx.bodyAsClass(Customer.class);
        int idToUpdate = Integer.parseInt(idParam);
        updatedUser.setId(idToUpdate);

        boolean success = userService.update(updatedUser);

        if(success)
            ctx.status(201);
        else
            ctx.status(400);
    }

}
