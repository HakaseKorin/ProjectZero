package com.revature.service;

import com.revature.dao.RestaurantDao;
import com.revature.dao.RestaurantDaoImpl;
import com.revature.models.MenuItem;
import com.revature.models.Restaurant;

public class RestaurantService {

    private RestaurantDao restaurantDao = new RestaurantDaoImpl();

    public boolean createRestaurant(String name, String address, String phone){
        Restaurant restaurant = new Restaurant(name, address, phone);
        return restaurantDao.createRestaurant(restaurant);
    }


}
