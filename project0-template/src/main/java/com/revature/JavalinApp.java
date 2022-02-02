package com.revature;

import com.revature.controller.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApp {

    private UserController userController = new UserController();

    private Javalin app = Javalin.create().routes(()->{
        path("users",()->{
            get(userController::handleGetAll);
            post(userController::handleCreateUser);
        });
        path("login", ()->{
        });
    });

    public void start(int port){app.start(port);}
}
