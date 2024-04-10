package com.example.digiwagen;

import java.io.Serializable;

public class CarListItem implements Serializable {
    private int image;
    private String name;

    private String descricao;
    private double rentPrice;

    public CarListItem(int image, String name, String descricao, double price) {
        this.image = image;
        this.name = name;
        this.rentPrice = price;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }


}
