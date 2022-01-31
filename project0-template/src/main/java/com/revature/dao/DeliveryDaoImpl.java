package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.Driver;
import com.revature.models.Order;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeliveryDaoImpl implements DeliveryDao{
    @Override
    public boolean createDelivery(Customer customer, Driver driver, String address) {
        String sql = "";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, customer.getEmail());
            ps.setString(2,customer.getPassword());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1 )
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

}
