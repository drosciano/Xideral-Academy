public class Center extends Jugador {
    Center(String nombre, int edad, Equipo equipo) {
        super(nombre, edad);
    }

    @Override
    int tirar() {
        return 2;
    }
}
