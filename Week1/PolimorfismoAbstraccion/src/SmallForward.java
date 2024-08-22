public class SmallForward extends Jugador {
    SmallForward(String nombre, int edad, int numero, double fielGoalPer, double threePointPer) {
        super(nombre, edad, numero, fielGoalPer, threePointPer);
    }

    @Override
    String funcion() {
        return "Ser una peligroso tirando y entrando a la canasta";
    }
}
