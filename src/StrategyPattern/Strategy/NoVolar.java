package StrategyPattern.Strategy;

public class NoVolar implements ComportamientoVolar {
    @Override
    public void ejecutaVuelo() {
        System.out.println("NO Vuelo");
    }
}
