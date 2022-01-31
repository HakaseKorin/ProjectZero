package com.revature.service;

import com.revature.models.Delivery;
import com.revature.models.Driver;
import com.revature.models.Order;

import java.util.List;
//import java.lang.Object;

public class DeliveryService {

    public Delivery createDelivery(Driver driver, List<Order> order, String restaurantAddress, String destinationAddress){
        Delivery delivery = new Delivery(driver, order, restaurantAddress, destinationAddress);
        return  delivery;
    }

    //public Driver getNearestDriver(List<Driver> drivers, String destination){
        //Driver bestDriver;
        //declare variable to store shortestDistance

        //test for each driver their address vs destination; set bestDriver to that driver

        //return  bestDriver;
    //}

    //create function to calculate distance between two addresses returns the distance;
}
