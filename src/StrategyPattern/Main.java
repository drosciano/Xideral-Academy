package StrategyPattern;

import StrategyPattern.Aves.Aguila;
import StrategyPattern.Aves.Ave;
import StrategyPattern.Aves.Pato;
import StrategyPattern.Aves.Pinguino;
import StrategyPattern.Strategy.AleatorioVolar;
import StrategyPattern.Strategy.ComportamientoVolar;
import StrategyPattern.Strategy.NoVolar;
import StrategyPattern.Strategy.SiVolar;

public class Main {
    public static void main(String[] args) {
        ComportamientoVolar cv1 = new SiVolar();
        ComportamientoVolar cv2 = new NoVolar();
        ComportamientoVolar cv3 = new AleatorioVolar();

        System.out.println("Aguila");
        Ave ave1 = new Aguila();
        ave1.volar();

        ave1.volar();

        System.out.println("Pato");
        Pato ave2 = new Pato();
        ave2.volar();

        System.out.println("Pinguino");
        Pinguino ave3 = new Pinguino();
        ave3.volar();
    }
}
