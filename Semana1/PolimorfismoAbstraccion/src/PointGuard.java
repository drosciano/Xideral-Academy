public class PointGuard extends Jugador {

    PointGuard(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    int tirar() {
        return 2;
    }
}
