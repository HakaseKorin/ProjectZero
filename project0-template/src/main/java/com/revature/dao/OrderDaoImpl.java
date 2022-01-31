package com.revature.dao;

import com.revature.models.Order;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao{

    //check later

    @Override
    public boolean createOrder(Order order, int customerId) {
        String sql = "insert into order ( customer_id, menu_item_id, quantity, restaurant_id) values (?, ?, ?, ?)";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1, customerId);
            ps.setInt(2,order.getItem().getId());
            ps.setInt(3,order.getQuantity());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1 )
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
