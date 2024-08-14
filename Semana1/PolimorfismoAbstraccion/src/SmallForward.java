public class SmallForward extends Jugador {
    SmallForward(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    int tirar() {
        return 2;
    }
}
