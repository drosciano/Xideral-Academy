package StrategyPattern.Aves;

import StrategyPattern.Strategy.ComportamientoVolar;
import StrategyPattern.Strategy.NoVolar;

public class Pinguino extends Ave{

    public Pinguino() {
        cv = new NoVolar();
    }
}
