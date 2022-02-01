package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.MenuItem;
import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.util.ConnectionUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDaoImpl implements MenuItemDao{

    @Override
    public boolean createMenuItem(MenuItem item) {
        String sql = "insert into menu_item (name, price, restaurant_id) values (?, ?, ?)";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, item.getName());
            ps.setFloat(2,item.getPrice());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1 )
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public MenuItem getMenuItemById(int id) {
        String sql = "select * from menu_item where id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                MenuItem menuItem = new MenuItem();

                menuItem.setId(id);
                menuItem.setName(rs.getString("name"));
                menuItem.setPrice(rs.getFloat("price"));

                if(rs.getString("description") != null)
                    menuItem.setDescription(rs.getString("description"));
                return menuItem;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<MenuItem> getMenuItemByRestaurantId(int id) {
        String sql = "select * from menu_item where restaurant_id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            List<MenuItem> restaurantMenu = new ArrayList<>();

            if(rs.next()){
                MenuItem menuItem = new MenuItem();
                menuItem.setId(rs.getInt("id"));
                menuItem.setName(rs.getString("name"));
                menuItem.setPrice(rs.getFloat("price"));
                menuItem.setDescription(rs.getString("description"));
                menuItem.setRestaurantId(id);

                restaurantMenu.add(menuItem);
            }
            return restaurantMenu;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
