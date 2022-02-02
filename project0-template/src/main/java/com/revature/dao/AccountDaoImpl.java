package com.revature.dao;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao{
    @Override
    public boolean createAccount(Account account) {
        String sql = "";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){


            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1)
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
