package org.example;

import org.junit.jupiter.api.Test;

import javax.management.InvalidApplicationException;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {

    //Test the attaching Observers to Subject via Constructor
    @Test
    void attach() {
        Product p1 = new Product("p1", 100.00);
        Observer o1 = new PriceObserver(p1);
        Observer o2 = new DiscountObserver(p1);
        List<Observer> o = new ArrayList<>();
        o.add(o1);
        o.add(o2);
        assertEquals(o, p1.getObservers());
    }

    //Test detaching Observers from Subjects
    @Test
    void detach() {
        Product p1 = new Product("p1", 100.00);
        Observer o1 = new PriceObserver(p1);
        Observer o2 = new DiscountObserver(p1);
        List<Observer> o = new ArrayList<>();
        p1.detach(o1);
        p1.detach(o2);
        assertEquals(o, p1.getObservers());
    }

    @Test
    void alert() {
    }

    //Test the Product constructor with a String for name and a double for a price
    //Use setters to check proper values inputed and check that the discount and sicount dates are not set
    @Test
    void Product() {
        Product prod1 = new Product("Product 1", 200.00);
        assertAll(() -> assertEquals("Product 1", prod1.getProductName()),
                () -> assertEquals(200.00, prod1.getPrice()),
                () -> assertEquals(200.00, prod1.getFullPrice()),
                () -> assertEquals(0.0, prod1.getDiscount()),
                () -> assertEquals(null, prod1.getDiscountEnd()),
                () -> assertEquals(null, prod1.getDiscountStart())
        );
    }

    //Try setDiscount(double) adds default discountDates
    //Check that the getPrice() get you the price with the discount and the getFullPrice gets you the full Price
    @Test
    void DiscountDefaultSetter() {
        Product prod1 = new Product("Product 1", 200.00);
        prod1.setDiscount(10.00);
        assertAll(
                () -> assertEquals(10.00, prod1.getDiscount()),
                () -> assertEquals(LocalDate.now(), prod1.getDiscountStart()),
                () -> assertEquals(LocalDate.now().plusDays(10), prod1.getDiscountEnd()),
                () -> assertEquals(180.00, prod1.getPrice()),
                () -> assertEquals(200.00, prod1.getFullPrice())
        );
    }

    @Test
    void DiscountSetter() {
        Product prod1 = new Product("Product 1", 200.00);
        prod1.setDiscount(10.00, LocalDate.now().plusDays(1), LocalDate.now().plusMonths(1));
        assertAll(
                () -> assertEquals(10.00, prod1.getDiscount()),
                () -> assertEquals(LocalDate.now().plusDays(1), prod1.getDiscountStart()),
                () -> assertEquals(LocalDate.now().plusMonths(1), prod1.getDiscountEnd()),
                () -> assertEquals(200.00, prod1.getPrice()),
                () -> assertEquals(200.00, prod1.getFullPrice())
        );
    }
}