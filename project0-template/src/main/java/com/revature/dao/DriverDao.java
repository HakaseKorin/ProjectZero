package com.revature.dao;

import com.revature.models.Driver;

import java.util.List;

public interface DriverDao {

    boolean createDriver(Driver driver);
    List<Driver> getAllDriver();
}
