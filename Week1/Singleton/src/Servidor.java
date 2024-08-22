import java.util.*;

public class Servidor {
    private static Servidor instance;
    private String conexion;
    private static List<Jugador> jugadores;
    private static String contraseña;

    private Servidor(String conexion, String contraseña) {
        this.conexion = conexion;
        this.contraseña = contraseña;
        this.jugadores = new ArrayList<Jugador>();
    }

    static Servidor getInstance() {
        if (instance == null) {
            instance = new Servidor("Servidor", "contraseña");
        }
        return instance;
    }

    boolean estaConectado(Jugador j) {
        return jugadores.contains(j);
    }

    static void conectar(Jugador j, String contraseña) throws Exception {
        if (Servidor.contraseña == contraseña) {
            jugadores.add(j);
        }
        else {
            throw new Exception(j + ", la contraseña del servidor no es valida");
        }
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
