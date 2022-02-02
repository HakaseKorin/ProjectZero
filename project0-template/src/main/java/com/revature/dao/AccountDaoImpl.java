package com.revature.dao;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.UserType;
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

                int typeOrdinal = rs.getInt("type");
                AccountType[] types = AccountType.values();
                account.setType(types[typeOrdinal]);

                return account;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean createAccount(Account account) {
        String sql = "insert into account(customer_id, type, balance) values (?, ?, ?)";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,account.getCustomerId());
            ps.setInt(2,account.getType().ordinal());
            ps.setFloat(3, account.getBalance());

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
