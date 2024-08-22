public class Center extends Jugador {
    Center(String nombre, int edad, int numero, double fielGoalPer, double threePointPer) {
        super(nombre, edad, numero, fielGoalPer, threePointPer);
    }

    @Override
    String funcion() {
        return "Ser alto para agarrar rebotes y jugadas de poder";
    }
}
