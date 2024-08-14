public class PowerForward extends Jugador {
    PowerForward(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    int tirar() {
        return 2;
    }
}
