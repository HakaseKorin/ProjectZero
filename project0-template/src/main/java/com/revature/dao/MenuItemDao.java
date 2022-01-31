package com.revature.dao;

import com.revature.models.MenuItem;

public interface MenuItemDao {
    boolean createMenuItem(MenuItem item);
    MenuItem getMenuItemById(int id);
}
