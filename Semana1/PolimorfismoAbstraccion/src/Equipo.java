public class Equipo {
    String nombre;
    Jugador[] titulares;
    Jugador[] banca;

    Equipo(String nombre, Jugador[] titulares, Jugador[] banca) {
        this.nombre = nombre;
        this.titulares = titulares;
        this.banca = banca;
    }
}
