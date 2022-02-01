package com.revature.dao;

import com.revature.models.Order;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    //check later
    private MenuItemDao menuItemDao = new MenuItemDaoImpl();

    @Override
    public int createOrderId(int customerId) {
        String sql = "insert into \"order\"(customer_id) values (?) returning id;";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,customerId);

            ResultSet rs = ps.executeQuery();

            return rs.getInt("id");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Order getMostRecentOrder(int customerId) {
        String sql = "select * from \"order\" where customer_id = ?;";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,customerId);

            ResultSet rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addToOrder(Order order) {
        String sql = "insert into order_item (order_id, menu_item_id, quantity) values (?, ?, ?)";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,order.getId());

            

            ps.setInt(2,order.getItem().getId());
            ps.setInt(3,order.getQuantity());

            return ps.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> getOrderById(int id) {
        String sql = "";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){



        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
