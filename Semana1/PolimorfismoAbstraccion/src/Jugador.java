public abstract class Jugador {
    String nombre;
    int edad;

    Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    abstract int tirar();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[Nombre = " + nombre + ", edad = " + edad + "]";
    }
}
