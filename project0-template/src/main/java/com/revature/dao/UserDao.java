package com.revature.dao;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao implements IUserDao{
    @Override
    public boolean createUser(User user) {
        if(user.getType().ordinal() == 0){
            String sql = "insert into \"user\" (email, password, type) values (?, crypt(?, gen_salt('md5'), 'customer')";
            try(Connection c = ConnectionUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){

                ps.setString(1,user.getEmail());
                ps.setString(2,user.getPassword());

                int rowsAffected = ps.executeUpdate();
                if(rowsAffected == 1)
                    return true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            String sqlType = user.getType().ordinal() == 1 ? "employee" : "admin";
            String sql = "insert into \"user\" (first, last, email, password, type) values (?, ?, "
                    + user.getFirst() + "." + user.getLast() + "@BankEmail.com, crypt('password', gen_salt('md5'), '" + sqlType + "')";

            try(Connection c = ConnectionUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){

                ps.setString(1,user.getFirst());
                ps.setString(2,user.getLast());

                int rowsAffected = ps.executeUpdate();
                if(rowsAffected == 1)
                    return true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return false;
    }
}
