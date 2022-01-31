package com.revature.service;

import com.revature.models.MenuItem;

public class MenuItemService {
    public MenuItem createMenuItem(int id, int restaurantId, String name, float price){
        MenuItem menuItem = new MenuItem(id, restaurantId, name, price);
        return menuItem;
    }
}
