package com.revature.service;

import com.revature.dao.AdminDao;
import com.revature.dao.AdminDaoImpl;
import com.revature.models.*;

public class AdminService {

    private AdminDao adminDao = new AdminDaoImpl();
    private CustomerService customerService = new CustomerService();
    private DriverService driverService = new DriverService();
    private RestaurantService restaurantService = new RestaurantService();

    public boolean createAdmin(String first, String last){
        Admin admin = new Admin(first, last);
        return adminDao.createAdmin(admin);
    }

    public void updatePassword(User user){}

    public void updateDriver(Driver driver){
        driverService.updateDriver(driver);
    }

    public void updateRestaurant(Restaurant restaurant){
        restaurantService.updateRestaurant(restaurant);
    }

    public void addToRestaurantMenu(Restaurant restaurant, MenuItem menuItem){
        restaurantService.addToMenu(restaurant, menuItem);
    }

    public void removeFromRestaurantMenu(Restaurant restaurant, MenuItem menuItem){
        restaurantService.removeFromMenu(restaurant, menuItem);
    }

    public void updateRestaurantMenu(Restaurant restaurant, MenuItem menuItem){
        restaurantService.updateMenu(restaurant, menuItem);
    }
}
