package com.revature.dao;

import com.revature.models.MenuItem;

import java.util.List;

public interface MenuItemDao {
    boolean createMenuItem(MenuItem item);
    MenuItem getMenuItemById(int id);
    List<MenuItem> getMenuItemByRestaurantId(int id);
}
