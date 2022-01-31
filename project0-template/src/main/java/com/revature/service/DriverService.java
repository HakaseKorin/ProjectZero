package com.revature.service;

import com.revature.dao.DriverDao;
import com.revature.dao.DriverDaoImpl;
import com.revature.models.Driver;

public class DriverService {

    private DriverDao driverDao = new DriverDaoImpl();

    public boolean createDriver(String email, String password, String first, String last, String address){
        Driver driver = new Driver(email, password, first, last, address);
        return driverDao.createDriver(driver);
    }

    public void checkDeliveries(Driver driver){}

    public void updateDriver(Driver driver){}
}
