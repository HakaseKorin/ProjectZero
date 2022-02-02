package com.revature;

import com.revature.controller.AccountController;
import com.revature.controller.AppExceptionHandler;
import com.revature.controller.AuthController;
import com.revature.controller.UserController;
import com.revature.util.LoggingUtil;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApp {

    private LoggingUtil loggingUtil = new LoggingUtil();
    private UserController userController = new UserController();
    private AuthController authController = new AuthController();
    private AccountController accountController = new AccountController();
    private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

    private Javalin app = Javalin.create().routes(()->{
        path("users",()->{
            get(userController::handleGetAll);
            post(userController::handleCreateUser);
            delete(userController::handleDeleteUser);
        });
        path("{id}", ()->{
            get(userController::handleByUserId);
            put(userController::handleUpdate);
        });
        path("login", ()->{
            post(authController::authenticateLogin);
        });
        path("accounts", ()->{
            get(accountController::handleByAccountId);
        });
        path("withdraw", ()->{
            put(accountController::handleWithdraw);
        });
        path("deposit", ()->{
            put(accountController::handleDeposit);
        });
        before("*",loggingUtil::logRequest);
    }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port){app.start(port);}
}
