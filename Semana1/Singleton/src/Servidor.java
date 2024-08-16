import java.util.*;

public class Servidor {
    private static Servidor instance;
    String conexion;
    static List<Jugador> jugadores;

    private Servidor(String conexion) {
        this.conexion = conexion;
        this.jugadores = new ArrayList<Jugador>();
    }

    static Servidor getInstance() {
        if (instance == null) {
            instance = new Servidor("Servidor");
        }
        return instance;
    }

    boolean estaConectado(Jugador j) {
        return jugadores.contains(j);
    }

    static void conectar(Jugador j) {
        jugadores.add(j);
    }

    static void desconectar(Jugador j) {
        jugadores.remove(j);
    }

    void mensaje() {
        System.out.println("Bienvenido a " + conexion + "!");
    }

    @Override
    public String toString() {
        return conexion;
    }
}
