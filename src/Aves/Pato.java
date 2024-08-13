package Aves;

import Strategy.ComportamientoVolar;

public class Pato implements Ave{
    ComportamientoVolar cv;

    @Override
    public void volar() {
        System.out.println("SI QUIERO Vuelo");
    }
}
