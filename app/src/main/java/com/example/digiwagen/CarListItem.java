package com.example.digiwagen;

public class CarListItem {
    private int image;
    private String name;
    private double rentPrice;

    public CarListItem(int image, String name, double price) {
        this.image = image;
        this.name = name;
        this.rentPrice = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }
}
