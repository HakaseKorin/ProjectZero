package com.revature.controller;

import com.revature.models.Customer;
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

        User user = userService.getByEmailAndPassword(username, password);

        if(user == null)
            throw new UnauthorizedResponse("Username or password is incorrect");
        else{
            String simpleToken = user.getType()+"-TOKEN";
            ctx.header("Authorization", simpleToken);
            ctx.status(200);
        }
    }

    public void authorizeDriverToken(Context ctx){
        String authHeader = ctx.header("Authorization");
        if(authHeader != null) {
            if (authHeader.equals("DRIVER-TOKEN")) {
                return;
            } else if (authHeader.equals("CUSTOMER-TOKEN")) {
                throw new ForbiddenResponse("customers are unable to access this feature");
            }
        }
        throw new UnauthorizedResponse("please login and try again");
    }

    //logout: remove token from header;
}
