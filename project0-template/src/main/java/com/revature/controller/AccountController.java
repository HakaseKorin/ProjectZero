package com.revature.controller;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.service.AccountService;
import com.revature.util.LoggingSingleton;
import io.javalin.http.Context;

public class AccountController {

    LoggingSingleton logger = LoggingSingleton.getLogger();
    private AccountService accountService = new AccountService();

    public void handleByAccountId(Context ctx) {
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        Account account = accountService.getById(id);
        ctx.json(account);
        logger.log("INFO", "an Account's info has been retrieved");
    }

    public void handleWithdraw(Context ctx) {
        String withdrawAmount = ctx.formParam("amount");
        String idParam = ctx.formParam("id");
        int id = Integer.parseInt(idParam);
        float amount = Float.parseFloat(withdrawAmount);
        Account account = accountService.getById(id);
        accountService.withdraw(account, amount);

        boolean success = accountService.update(account);

        if(success) {
            logger.log("INFO", "successful withdrawl");
            ctx.status(201);
        }else{
            logger.log("WARN","withdrawl failed");
            ctx.status(400);
        }
    }

    public void handleDeposit(Context ctx) {
        String depositAmount = ctx.formParam("amount");
        String idParam = ctx.formParam("id");
        int id = Integer.parseInt(idParam);
        float amount = Float.parseFloat(depositAmount);
        Account account = accountService.getById(id);
        accountService.deposit(account, amount);

        boolean success = accountService.update(account);

        if(success) {
            logger.log("INFO", "successful deposit");
            ctx.status(201);
        }else{
            logger.log("WARN","deposit failed");
            ctx.status(400);
        }
    }
}
