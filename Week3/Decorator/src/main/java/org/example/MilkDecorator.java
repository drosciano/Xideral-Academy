package org.example;

public class MilkDecorator extends DrinkDecorator {
    MilkDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 0.50;
    }
}
