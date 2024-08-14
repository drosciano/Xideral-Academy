public class ShootingGuard extends Jugador{
    ShootingGuard(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    int tirar() {
        return 2;
    }
}
