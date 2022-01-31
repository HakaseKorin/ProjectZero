package com.revature.models;

import java.util.List;

public class Delivery {
    private Driver driver;
    private List<Order> order;
    private String restaurantAddress;
    private String destinationAddress;
    private boolean isPickedUp;
    private boolean isDelivered;

    public Delivery(Driver driver, List<Order> order, String restaurantAddress, String destinationAddress) {
        this.driver = driver;
        this.order = order;
        this.restaurantAddress = restaurantAddress;
        this.destinationAddress = destinationAddress;
        this.isPickedUp = false;
        this.isDelivered = false;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public boolean isPickedUp() {
        return isPickedUp;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void pickUpOrder(){
        this.isPickedUp = true;
    }

    public void deliverOrder(){
        this.isDelivered = true;
    }
}
