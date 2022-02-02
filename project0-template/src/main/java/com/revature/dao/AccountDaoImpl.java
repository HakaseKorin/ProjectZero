package com.revature.dao;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class AccountDaoImpl implements AccountDao{
    @Override
    public Account getById(int id) {
        String sql = "select * from account where id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Account account = new Account();
                account.setId(id);
                account.setCustomerId(rs.getInt("customer_id"));
                account.setBalance(rs.getFloat("balance"));

                return account;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

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

    @Override
    public boolean update(Account account) {
        String sql = "update account set balance = ? where id = ?";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setFloat(1,account.getBalance());
            ps.setInt(2,account.getId());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1)
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
