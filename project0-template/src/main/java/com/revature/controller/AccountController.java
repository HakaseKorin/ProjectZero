package com.revature.controller;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.service.AccountService;
import io.javalin.http.Context;

public class AccountController {

    private AccountService accountService = new AccountService();

    public void handleGetOne(Context ctx) {
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        Account account= accountService.getById(id);
        ctx.json(account);
    }

    public void handleWithdraw(Context ctx) {
        String withdrawAmount = ctx.formParam("amount");
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        float amount = Float.parseFloat(withdrawAmount);
        Account account = accountService.getById(id);
        accountService.withdraw(account, amount);

        boolean success = accountService.update(account);

        if(success)
            ctx.status(201);
        else
            ctx.status(400);
    }

    public void handleDeposit(Context ctx) {
        String depositAmount = ctx.formParam("amount");
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        float amount = Float.parseFloat(depositAmount);
        Account account = accountService.getById(id);
        accountService.deposit(account, amount);

        boolean success = accountService.update(account);

        if(success)
            ctx.status(201);
        else
            ctx.status(400);
    }
}
