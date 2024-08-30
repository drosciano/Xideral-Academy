package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {

    @Test
    void getDescription() {
        Drink d1 = new Coffee(2.50, "Coffee");
        Drink d2 = new Chocolate(3.00, "Chocolate");

        assertAll(
                () -> assertEquals("Coffee", d1.getDescription()),
                () -> assertEquals("Chocolate", d2.getDescription())
        );
    }

    @Test
    void getPrice() {
        Drink d1 = new Coffee(2.50, "Coffee");
        Drink d2 = new Chocolate(3.00, "Chocolate");

        assertAll(
                () -> assertEquals(2.50, d1.getPrice()),
                () -> assertEquals(3.00, d2.getPrice())
        );
    }

    @Test
    void getDrinkChanged() {
        Drink d1 = new Coffee(2.50, "Coffee");
        Drink decoratedD1 = new WhipCreamDecorator(d1);
        assertAll(
                () -> assertEquals("Coffee, Whip Cream", decoratedD1.getDescription()),
                () -> assertEquals(2.75, decoratedD1.getPrice())
        );
    }

    @Test
    void multipleDecorators() {
        Drink d1 = new Coffee(2.50, "Coffee");
        Drink decorated1D1 = new WhipCreamDecorator(d1);
        Drink decorated2D1 = new MilkDecorator(decorated1D1);
        assertAll(
                () -> assertEquals("Coffee, Whip Cream, Milk", decorated2D1.getDescription()),
                () -> assertEquals(3.25, decorated2D1.getPrice())
        );
    }

}