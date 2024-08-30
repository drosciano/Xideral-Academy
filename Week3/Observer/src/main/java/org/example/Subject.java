package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observers = new ArrayList<>();

    void attach(Observer o) {
        observers.add(o);
    }

    void detach(Observer o) {
        observers.removeIf(x -> x.equals(o));
    }

    public List<Observer> getObservers() {
        return observers;
    }

    void update(Product p) {
        for (Observer o : observers) {
            o.update(p);
        }
    }
}
