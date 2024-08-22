public class ShootingGuard extends Jugador{
    ShootingGuard(String nombre, int edad, int numero, double fielGoalPer, double threePointPer) {
        super(nombre, edad, numero, fielGoalPer, threePointPer);
    }

    @Override
    String funcion() {
        return "Ser un tirador eficiente";
    }
}
