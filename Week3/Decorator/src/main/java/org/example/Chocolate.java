package org.example;

public class Chocolate implements Drink {
    double price;
    String description;

    Chocolate(double price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
