package org.example;

public class PriceObserver extends Observer {
    double price;

    PriceObserver(Subject sub) {
        super(sub);
    }

    void alert(Product p) {
        if (price > p.getFullPrice()) {
            System.out.println("Buy now! " + p.getProductName() + " is " + (price - p.getFullPrice()) + " cheaper than usual!");
        }
        else if (price < p.getFullPrice()) {
            System.out.println(p.getProductName() + " has increased their price by " + (-price + p.getFullPrice()) + ":(");
        }
        else {
            System.out.println(p.getProductName() + " price hasn't changed");
        }
        price = p.getFullPrice();
    }

    @Override
    void update(Product p) {
        alert(p);
    }
}
