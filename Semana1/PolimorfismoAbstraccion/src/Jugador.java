public abstract class Jugador {
    private String nombre;
    private int edad;
    private int numero;
    private String pos;
    private int puntos;
    private double fieldGoalPer;
    private double threePointPer;

    Jugador(String nombre, int edad, int numero, double fieldGoalPer, double threePointPer) {
        this.nombre = nombre;
        this.edad = edad;
        this.numero = numero;
        this.fieldGoalPer = fieldGoalPer;
        this.threePointPer = threePointPer;
        //Asignar la abreviacion correcta a la posicion del Jugador para mejor sintaxis al momento de imprimir
        switch (this.getClass().getSimpleName()) {
            case("PointGuard"):
                pos = "PG";
                break;
            case("ShootingGuard"):
                pos = "SG";
                break;
            case("SmallForward"):
                pos = "SF";
                break;
            case("PowerForward"):
                pos = "PF";
                break;
            case("Center"):
                pos = "C";
                break;
            default:
                pos = "N/A";
                break;
        }
    }

    abstract String funcion();

    int getPuntos() {
        return this.puntos;
    }

    void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    int tirar() {
        int tiro;
        double prob;
        double probTriple;
        prob = (Math.random() * 100);
        probTriple = (Math.random() * 100);
        if (prob > this.fieldGoalPer) {
            tiro = 0;
        }
        else if (probTriple > this.threePointPer){
            tiro = 2;
            this.puntos += 2;
        }
        else {
            tiro = 3;
            this.puntos += 3;
        }
        System.out.println(nombre + ": " + (tiro == 0 ? "fallo el tiro." : tiro + " puntos"));
        return tiro;
    }

    @Override
    public String toString() {
        return pos + ": " + nombre;
    }
}
