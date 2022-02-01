package com.revature.service;

import com.revature.dao.MenuItemDao;
import com.revature.dao.MenuItemDaoImpl;
import com.revature.models.MenuItem;

public class MenuItemService {

    private MenuItemDao menuItemDao = new MenuItemDaoImpl();

    public MenuItem createMenuItem(int id, int restaurantId, String name, float price){
        MenuItem menuItem = new MenuItem(id, restaurantId, name, price);
        return menuItem;
    }

    public MenuItem getMenuItemById(int id){return menuItemDao.getMenuItemById(id);}
}
