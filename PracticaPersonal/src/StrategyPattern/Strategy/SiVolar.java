package StrategyPattern.Strategy;

public class SiVolar implements ComportamientoVolar {
    @Override
    public void ejecutaVuelo() {
        System.out.println("SI Vuelo");
    }
}
