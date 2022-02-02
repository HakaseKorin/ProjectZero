package com.revature.controller;

import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.util.LoggingSingleton;
import io.javalin.http.Context;

import java.util.List;

public class UserController {

    LoggingSingleton logger = LoggingSingleton.getLogger();
    UserService userService = new UserService();

    public void handleCreateUser(Context ctx){
        Customer user = ctx.bodyAsClass(Customer.class);
        boolean success = userService.createUser(user);

        if(success) {
            ctx.status(201);
            logger.log("INFO","user has been created");
        }else{
            ctx.status(400);
            logger.log("WARN","user failed to be created");
        }
    }

    public void handleGetAll(Context ctx){
        List<User> users = userService.getAll();
        ctx.json(users);
        logger.log("INFO", "all users were retrieved");
    }

    public void handleByUserId(Context ctx){
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        User user = userService.getById(id);
        ctx.json(user);
        logger.log("INFO","one user was retrieved");
    }

    public void handleUpdate(Context ctx){
        String idParam = ctx.pathParam("id");
        User updatedUser = ctx.bodyAsClass(Customer.class);
        int idToUpdate = Integer.parseInt(idParam);
        updatedUser.setId(idToUpdate);

        boolean success = userService.update(updatedUser);

        if(success) {
            ctx.status(201);
            logger.log("INFO","a user's information has been updated");
        }else{
            ctx.status(400);
            logger.log("WARN","a user's information failed to update");
        }
    }

    public void handleDeleteUser(Context ctx) {
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        userService.deleteUserById(id);
    }
}
