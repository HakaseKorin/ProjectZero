package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.Delivery;
import com.revature.models.Driver;
import com.revature.models.Order;
import com.revature.service.DriverService;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeliveryDaoImpl implements DeliveryDao{

    private DriverDao driverDao = new DriverDaoImpl();

    @Override
    public boolean createDelivery(Delivery delivery, int orderId) {
        String sql = "insert into delivery (order_id, driver_id, is_picked_up, is_delivered) values (?, ?, ?, ?)";

        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1, orderId);

            List<Driver> drivers = driverDao.getAllDriver();
            Driver avaliableDriver = null;
            for(Driver d : drivers)
                if(d.isAvaliable()){
                    avaliableDriver = d;
                    break;
                }

            if(avaliableDriver == null)
                return false;

            ps.setInt(2, avaliableDriver.getUserId());
            ps.setBoolean(3, delivery.isPickedUp());
            ps.setBoolean(4, delivery.isDelivered());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1 )
                return true;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

}
