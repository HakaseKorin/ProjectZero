package com.revature.dao;

import com.revature.models.Customer;
import com.revature.models.Driver;
import com.revature.models.Order;

import java.sql.Date;
import java.util.List;

public interface DeliveryDao {

    boolean createDelivery(Customer customer, Driver driver, String address);

}
