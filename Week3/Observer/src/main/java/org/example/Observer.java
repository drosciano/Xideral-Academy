package org.example;

public abstract class Observer {
    Observer(Subject sub) {
        sub.attach(this);
    }

    abstract void update(Product p);
}
