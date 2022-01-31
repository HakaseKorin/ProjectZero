package com.revature.models;

public class MenuItem {
    private int id;
    private int restaurantId;
    private String name;
    private float price;
    private String description;

    public MenuItem() {
    }

    public MenuItem(int id, int restaurantId, String name, float price) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
