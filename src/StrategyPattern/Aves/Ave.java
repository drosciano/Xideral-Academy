package StrategyPattern.Aves;

import StrategyPattern.Strategy.ComportamientoVolar;
import StrategyPattern.Strategy.SiVolar;

public abstract class Ave {

    ComportamientoVolar cv = new SiVolar();

     public void volar() {
         cv.ejecutaVuelo();
     };
}
