package Aves;

import Strategy.AleatorioVolar;
import Strategy.ComportamientoVolar;
import Strategy.NoVolar;
import Strategy.SiVolar;

public class Main {
    public static void main(String[] args) {
        ComportamientoVolar cv1 = new SiVolar();
        ComportamientoVolar cv2 = new NoVolar();
        ComportamientoVolar cv3 = new AleatorioVolar();

        System.out.println("Aguila");
        Aguila ave1 = new Aguila();
        ave1.cv = cv1;
        ave1.volar();

        ave1.cv = cv2;
        ave1.volar();

        System.out.println("Pato");
        Pato ave2 = new Pato();
        ave2.cv = cv3;
        ave2.volar();

        System.out.println("Pinguino");
        Pinguino ave3 = new Pinguino();
        ave3.cv = cv2;
        ave3.volar();
    }
}
