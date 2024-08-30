package org.example;

public class WhipCreamDecorator extends DrinkDecorator {
    Drink drink;
    WhipCreamDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip Cream";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 0.25;
    }
}
