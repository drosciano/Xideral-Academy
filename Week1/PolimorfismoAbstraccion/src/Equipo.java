import java.util.Arrays;

public class Equipo {
    String nombre;
    Jugador[] jugadores;

    Equipo(String nombre, Jugador[] jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {

        return nombre + "\n" +
                printJugadores();
    }

    private String printJugadores() {
        StringBuilder result = new StringBuilder();
        for(Jugador j : jugadores) {
            result.append(j + "\n");
        }
        return result.toString();
    }

    public int tirar() {
        int index = (int)(Math.random() * 5);
        return jugadores[index].tirar();
    }
}
