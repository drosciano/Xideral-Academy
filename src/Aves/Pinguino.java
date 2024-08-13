package Aves;

import Strategy.ComportamientoVolar;

public class Pinguino implements Ave{
    ComportamientoVolar cv;

    @Override
    public void volar() {
        System.out.println("NO Vuelo");
    }
}
