package com.revature.dao;

import com.revature.models.Driver;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DriverDaoImpl implements DriverDao{


    @Override
    public boolean createDriver(Driver driver) {
        String sql =    "insert into \"user\" (email, password, type, first, last, address) " +
                        "values(?, crypt('?', gen_salt('md5') , 'driver', ? , ?, ?)";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, driver.getEmail());
            ps.setString(2, driver.getPassword());
            ps.setString(3, driver.getFirst());
            ps.setString(4, driver.getLast());
            ps.setString(5, driver.getAddress());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1 )
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
