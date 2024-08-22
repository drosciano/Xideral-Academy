public class PowerForward extends Jugador {
    PowerForward(String nombre, int edad, int numero, double fielGoalPer, double threePointPer) {
        super(nombre, edad, numero, fielGoalPer, threePointPer);
    }

    @Override
    String funcion() {
        return "Tener la fuerza y agilidad para poder entrar a la canasta";
    }
}
