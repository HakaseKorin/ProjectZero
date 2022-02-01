package com.revature.service;

import com.revature.dao.*;
import com.revature.models.*;

import java.util.List;

public class UserService {

    private AdminDao adminDao = new AdminDaoImpl();
    private DriverDao driverDao = new DriverDaoImpl();
    private CustomerDao customerDao = new CustomerDaoImpl();
    private RestaurantDao restaurantDao = new RestaurantDaoImpl();
    private UserDao userDao = new UserDaoImpl();


    public boolean createAdmin(String first, String last){
        Admin admin = new Admin(first, last);
        return adminDao.createAdmin(admin);
    }

    public boolean createCustomer(String email, String password){
        Customer customer = new Customer(email, password);
        return  customerDao.createCustomer(customer);
    }

    public boolean createDriver(String email, String password, String first, String last, String address){
        Driver driver = new Driver(email, password, first, last, address);
        return driverDao.createDriver(driver);
    }

    public boolean createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    public boolean createDriver(Driver driver){
        return driverDao.createDriver(driver);
    }

    public User getById(int id){return userDao.getUserById(id);}

    public List<Driver> getAllDriver(){return driverDao.getAllDriver();}

    public User getByEmailAndPassword(String email, String password){
        return userDao.getUserByEmailAndPassword(email, password);
    }
}
