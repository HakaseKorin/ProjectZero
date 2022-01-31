package com.revature.service;

import com.revature.models.MenuItem;

public class MenuItemService {
    public MenuItem createMenuItem(String name, float price, String description){
        MenuItem menuItem = new MenuItem(name, price, description);
        return menuItem;
    }
}
