import com.sun.management.UnixOperatingSystemMXBean;

public class Jugador {
    Servidor servidor;
    String usuario;
    String contraseña;

    Jugador(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    void conectarServidor(String usuario, String contraseña) {
        if (this.usuario == usuario && this.contraseña == contraseña) {
            servidor = Servidor.getInstance();
            Servidor.conectar(this);
            System.out.println(usuario + " se ha conectado a " + servidor);
        }
        else {
            System.out.println("Usuario o Contraseña equivocada, intente de nuevo.");
        }
    }
    void desconectarServidor() {
        Servidor.desconectar(this);
        System.out.println(usuario + " se ha desconectado de " + servidor);
        this.servidor = null;
    }

    void interactuarCon(Jugador j) {
        if (servidor.estaConectado(j)) {
            System.out.println("Hola " + j + "! ¿Cómo estas?");
        }
        else {
            System.out.println("No se pudo encontrar a " + j + " en el servidor");
        }
    }

    @Override
    public String toString() {
        return usuario;
    }
}
