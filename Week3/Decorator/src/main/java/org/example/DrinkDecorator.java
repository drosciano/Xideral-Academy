package org.example;

public class DrinkDecorator implements Drink {
    Drink drink;
    DrinkDecorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String getDescription() {
        return drink.getDescription();
    }

    @Override
    public double getPrice() {
        return drink.getPrice();
    }
}
