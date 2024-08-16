import com.sun.management.UnixOperatingSystemMXBean;

public class Jugador {
    private Servidor servidor;
    private String usuario;
    private String contraseña;

    Jugador(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Servidor getServidor() {
        return servidor;
    }

    void conectarServidor(String usuario, String contraseña, String contraseñaServidor) {
        if (this.usuario == usuario && this.contraseña == contraseña) {
            try {
                servidor = Servidor.getInstance();
                Servidor.conectar(this, contraseñaServidor);
                System.out.println(usuario + " se ha conectado a " + servidor);
            } catch (Exception e) {
                System.out.println(e);
            }
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
        if (servidor != null) {
            if (servidor.estaConectado(j)) {
                System.out.println(usuario + ": Hola " + j + "! ¿Cómo estas?");
            }
            else {
                System.out.println("No se pudo encontrar a " + j + " en el servidor");
            }
        }
        else {
            System.out.println("No puedes interactuar sin estar conectado");
        }
    }

    @Override
    public String toString() {
        return usuario;
    }
}
