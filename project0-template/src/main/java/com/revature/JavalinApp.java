package com.revature;

import com.revature.controller.AccountController;
import com.revature.controller.AuthController;
import com.revature.controller.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApp {

    private UserController userController = new UserController();
    private AuthController authController = new AuthController();
    private AccountController accountController = new AccountController();

    private Javalin app = Javalin.create().routes(()->{
        path("users",()->{
            get(userController::handleGetAll);
            post(userController::handleCreateUser);
        });
        path("{id}", ()->{
            get(userController::handleGetOne);
            put(userController::handleUpdate);
        });
        path("accounts", ()->{
            get(accountController::handleGetOne);
        });
        path("withdraw", ()->{
            put(accountController::handleWithdraw);
        });
        path("deposit", ()->{
            put(accountController::handleDeposit);
        });
        path("login", ()->{
            post(authController::authenticateLogin);
        });
    });

    public void start(int port){app.start(port);}
}
