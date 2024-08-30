package org.example;

public class Coffee implements Drink {
    double price;
    String description;

    Coffee(double price, String description) {
        this.price = price;
        this. description = description;
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
