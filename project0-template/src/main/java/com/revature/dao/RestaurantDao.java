package com.revature.dao;

import com.revature.models.Restaurant;

public interface RestaurantDao {

    boolean createRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(int id);
}
