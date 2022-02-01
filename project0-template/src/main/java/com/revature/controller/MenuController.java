package com.revature.controller;

import com.revature.models.MenuItem;
import com.revature.models.User;
import com.revature.service.MenuItemService;
import io.javalin.http.Context;

public class MenuController {

    MenuItemService menuItemService = new MenuItemService();

    public void handleGetOne(Context ctx){
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        ctx.json(menuItem);
    }

    //get by restaurant?
}
