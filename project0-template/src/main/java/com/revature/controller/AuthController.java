package com.revature.controller;

import com.revature.models.User;
import com.revature.service.UserService;
import io.javalin.http.Context;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.UnauthorizedResponse;

public class AuthController {

    private UserService userService = new UserService();

    public void authenticateLogin(Context ctx){
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = userService.getByUserAndPass(username, password);

        if(user == null)
            throw new UnauthorizedResponse("Incorrect username or password");
        else {
            String simpleToken = user.getType()+"-TOKEN";
            ctx.header("Authorization", simpleToken);
            ctx.status(200);
        }
    }

    public void authorizeAdminToken(Context ctx){
        String authHeader = ctx.header("Authorization");
        if(authHeader!=null){
            if(authHeader.equals("ADMIN-TOKEN")){return;}
            else {
                throw new ForbiddenResponse("You are not allowed to access this feature");
            }
        }
        throw new UnauthorizedResponse("Please login and try again");
    }
}
