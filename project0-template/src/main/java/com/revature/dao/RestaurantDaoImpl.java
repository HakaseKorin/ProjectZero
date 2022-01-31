package com.revature.dao;

import com.revature.models.Restaurant;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantDaoImpl implements RestaurantDao {

    @Override
    public boolean createRestaurant(Restaurant restaurant) {
        String sql = "insert into restaurant (name, address, phone) values (?, ?, ?)";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getAddress());
            ps.setString(3, restaurant.getPhone());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1 )
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        String sql = "select * from restaurant where id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setId(id);

                restaurant.setName(rs.getString("name"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setPhone(rs.getString("phone"));

                return restaurant;
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
