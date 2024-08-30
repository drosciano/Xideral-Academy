package org.example;

import java.time.LocalDate;

public class Product extends Subject {
    private String productName;
    private double price;
    private double discount;
    private LocalDate discountStart;
    private LocalDate discountEnd;

    Product(String name, double price) {
        this.productName = name;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getFullPrice() {
        return this.price;
    }

    public double getPrice() {
        if (this.discountEnd != null) {
            if (!(LocalDate.now().isBefore(this.discountStart) || LocalDate.now().isAfter(this.discountEnd))) {
                return this.price * (1 - this.discount / 100.00);
            }
        }
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public LocalDate getDiscountEnd() {
        return this.discountEnd;
    }

    public LocalDate getDiscountStart() {
        return this.discountStart;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        this.discountStart = LocalDate.now();
        this.discountEnd = LocalDate.now().plusDays(10);
        update(this);
    }

    public void setDiscount(double discount, LocalDate discountStart, LocalDate discountEnd) {
        this.discount = discount;
        this.discountStart = discountStart;
        this.discountEnd = discountEnd;
        update(this);
    }

    public void setPrice(double price) {
        this.price = price;
        update(this);
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
