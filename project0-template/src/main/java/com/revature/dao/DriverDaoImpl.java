package com.revature.dao;

import com.revature.models.Driver;
import com.revature.models.Restaurant;
import com.revature.models.UserType;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDaoImpl implements DriverDao{


    @Override
    public boolean createDriver(Driver driver) {
        String sql =    "insert into \"user\" (email, password, type, first, last, address) " +
                        "values(?, crypt('?', gen_salt('md5')) , 'driver', ? , ?, ?)";
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

    @Override
    public List<Driver> getAllDriver() {
        String sql = "select * from \"user\" where \"type\" = 'driver';";
        List<Driver> driverList = new ArrayList<>();

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Driver driver = new Driver();

                driver.setUserId(rs.getInt("id"));
                driver.setFirst(rs.getString("first"));
                driver.setLast(rs.getString("last"));
                driver.setEmail(rs.getString("email"));
                driver.setAddress(rs.getString("address"));
                driver.setType(UserType.DRIVER);

                driverList.add(driver);
            }

            return driverList;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
