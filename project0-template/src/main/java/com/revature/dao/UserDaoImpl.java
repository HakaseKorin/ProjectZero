package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDaoImpl implements UserDao{
    @Override
    public boolean createUser(User user) {
        if(user.getType().ordinal() == 0){
            String sql = "insert into \"user\" (email, \"password\", first, last, type) " +
                    "values (?, crypt(?, gen_salt('md5')), ?, ?, ?);";
            try(Connection c = ConnectionUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){

                ps.setString(1,user.getEmail());
                ps.setString(2,user.getPassword());
                ps.setString(3,user.getFirst());
                ps.setString(4,user.getLast());
                ps.setString(5,  "customer");

                int rowsAffected = ps.executeUpdate();
                if(rowsAffected == 1)
                    return true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            String sqlType = user.getType().ordinal() == 1 ? "employee" : "admin";
            String sql = "insert into \"user\" (email, \"password\", first, last, type) " +
                    "values (?, crypt(?, gen_salt('md5')), ?, ?, ?);";

            try(Connection c = ConnectionUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){

                ps.setString(1,(user.getFirst()+"."+user.getLast()+"@Bank.com"));
                ps.setString(2,"password");
                ps.setString(3,user.getFirst());
                ps.setString(4,user.getLast());
                ps.setString(5,sqlType);

                int rowsAffected = ps.executeUpdate();
                if(rowsAffected == 1)
                    return true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        String sql = "select * from person where email = ? and password = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User user = new Customer();
                user.setId(rs.getInt("id"));
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
    public List<User> getAll() {
        String sql = "select * from \"user\"";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            List<User> users = new ArrayList<>();

            while(rs.next()){
                User user = new Customer();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirst(rs.getString("first"));
                user.setLast(rs.getString("last"));
                user.setType(UserType.valueOf(rs.getString("type")));

                users.add(user);
            }
            return users;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getById(int id) {
        String sql = "select * from \"user\" where id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User user = new Customer();
                user.setId(rs.getInt("id"));
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
    public boolean update(User updatedUser) {
        String sql = "update \"user\" set email = ?, " +
                "password = crypt(?, gen_salt('md5')), first = ?, last = ?, type = ? where id = ?";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1,updatedUser.getEmail());
            ps.setString(2,updatedUser.getPassword());
            ps.setString(3,updatedUser.getFirst());
            ps.setString(4,updatedUser.getLast());
            ps.setString(5,updatedUser.getType().toString().toLowerCase(Locale.ROOT));
            ps.setInt(6,updatedUser.getId());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1)
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
