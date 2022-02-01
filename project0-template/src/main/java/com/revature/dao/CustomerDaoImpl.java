package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.Order;
import com.revature.util.ConnectionUtil;
import java.sql.*;
import java.util.List;


public class CustomerDaoImpl implements CustomerDao{

    @Override
    public boolean createCustomer(Customer customer) {
        String sql = "insert into \"user\" (email, password, type) values(?, crypt('?', gen_salt('md5') , 'customer')";
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
