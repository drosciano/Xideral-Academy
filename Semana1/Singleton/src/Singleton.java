public class Singleton {
    private static Singleton instance;
    String conexion;

    private Singleton(String conexion) {
        this.conexion = conexion;
    }

    static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton("Conexion SQL");
        }
        return instance;
    }

    void mensaje() {
        System.out.println("La conexion con singleton esta inicializada");
    }

    @Override
    public String toString() {
        return "Singleton: [conexion = " + conexion + "]";
    }
}
