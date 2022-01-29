package com.revature.dao;

import com.revature.models.Admin;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean createAdmin(Admin admin) {
        String sql = "insert into \"user\" (email, password, type, first, last) values(?, crypt('?', gen_salt('md5') , 'admin', ?, ?)";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, admin.getEmail());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getFirst());
            ps.setString(4, admin.getLast());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1 )
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
