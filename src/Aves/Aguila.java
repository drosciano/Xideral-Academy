package Aves;

import Strategy.ComportamientoVolar;

public class Aguila implements Ave{

    public ComportamientoVolar cv;

    @Override
    public void volar() {
        cv.ejecutaVuelo();
    }
}
