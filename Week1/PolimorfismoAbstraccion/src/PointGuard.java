public class PointGuard extends Jugador {

    PointGuard(String nombre, int edad, int numero, double fielGoalPer, double threePointPer) {
        super(nombre, edad, numero, fielGoalPer, threePointPer);
    }

    @Override
    String funcion() {
        return "Hacer jugadas, pasar el balon";
    }
}
