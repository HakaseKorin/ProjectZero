package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class UserDaoImpl implements UserDao{

    //!Test
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "select * from \"user\" where email = ? and where password = crypt('?', gen_salt('md5')";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User user = new Customer();

                user.setUserId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirst(rs.getString("first"));
                user.setLast(rs.getString("last"));
                user.setType(UserType.valueOf(rs.getString("type")));

                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        String sql = "select * from \"user\" where id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User user = new Customer();

                user.setUserId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirst(rs.getString("first"));
                user.setLast(rs.getString("last"));
                user.setType(UserType.valueOf(rs.getString("type")));

                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
