package com.revature.models;

import java.util.List;

public class Delivery {
    private int driverId;
    private List<Order> order;
    private String restaurantAddress;
    private String destinationAddress;
    private boolean isPickedUp;
    private boolean isDelivered;

    public Delivery(int driverId, List<Order> order, String restaurantAddress, String destinationAddress) {
        this.driverId = driverId;
        this.order = order;
        this.restaurantAddress = restaurantAddress;
        this.destinationAddress = destinationAddress;
        this.isPickedUp = false;
        this.isDelivered = false;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
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

    public void pickUpOrder(){
        this.isPickedUp = true;
    }

    public void deliverOrder(){
        this.isDelivered = true;
    }
}
