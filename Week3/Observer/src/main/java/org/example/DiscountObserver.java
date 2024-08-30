package org.example;

import java.time.LocalDate;

public class DiscountObserver extends Observer {
    double discount;

    DiscountObserver(Subject sub) {
        super(sub);
    }

    void alert(Product p) {
        System.out.println("Crazy Discount! " + p.getProductName() + " has a " + p.getDiscount() + "% discount until " + p.getDiscountEnd());
    }

    @Override
    void update(Product p) {
        if (p.getDiscountEnd() != null){
            if (LocalDate.now().compareTo(p.getDiscountEnd()) <= 0) {
                alert(p);
            }
        }
    }
}
