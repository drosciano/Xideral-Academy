import java.awt.desktop.SystemSleepListener;

public class Partido  {
    Equipo equipo1;
    Equipo equipo2;
    int posesiones;
    //El marcador es un int[] simulando que
    //marcador[0] representa al equipo 1
    //y marcador[1] representa al equipo 2
    int[] marcador = new int[2];

    Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        //Asignar un numero de posesiones random en un rango basado en el promedio de posesiones de la NBA
        this.posesiones = (int)(Math.random() * 10) + 100;
    }

    @Override
    public String toString() {
        return partidoRooster();
    }

    private String partidoRooster() {
        //Reformatear el StringBuilder para que podamos ver a ambos equipos lado a lado
        StringBuilder result = new StringBuilder();
        result.append(String.format("%-25s %-14s %s" , equipo1.nombre, "vs", equipo2.nombre) + "\n");
        for(int i = 0; i < equipo1.jugadores.length; i++) {
            result.append(String.format("%-40s %s" , equipo1.jugadores[i], equipo2.jugadores[i]) + "\n");
        }

        return result.toString();
    }

    public void simularPartido() {
        //Asegurarme que los puntos de todos los jugadores sea 0
        for (Jugador j : equipo1.jugadores) {
            j.setPuntos(0);
        }
        for (Jugador j : equipo2.jugadores) {
            j.setPuntos(0);
        }
        //Simular el numero de posesiones del partido.
        //La Primera Posesion es del equipo 1, la segunda del equipo 2 y asi sucesivamente
        for (int i = 0; i < posesiones; i++) {
            int tiro;
            double probRebote = Math.random() * 11;
            if (i % 2 == 0) {
                tiro = equipo1.tirar();
                //Pequeña probabilidad de agarrar el rebote e intentar de nuevo
                if (tiro == 0 && probRebote <= 2) {
                    i--;
                    continue;
                }
                marcador[0] += tiro;
            }
            else {
                tiro = equipo2.tirar();
                //Pequeña probabilidad de agarrar el rebote e intentar de nuevo
                if (tiro == 0 && probRebote <= 2) {
                    i--;
                    continue;
                }
                marcador[1] += tiro;
            }
            //Imprimir el Marcador para ver como va despues de cada posesion
            System.out.println(equipo1.nombre + " | " + marcador[0] + " | " + marcador[1] + " | " + equipo2.nombre);
        }
        System.out.println();
        System.out.println((marcador[0] != marcador[1] ? (marcador[0] > marcador[1] ? "LOS " + equipo1.nombre + " HAN GANADO!!!" : "LOS " + equipo2.nombre + " HAN GANADO!!!") : "El Partido Termino en Empate"));
    }
    public void marcadorFinal() {
        System.out.println(equipo1.nombre + " | " + marcador[0] + " | " + marcador[1] + " | " + equipo2.nombre);
    }

    public void estadisticas() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%-40s %s" , equipo1.nombre, equipo2.nombre) + "\n");
        for(int i = 0; i < equipo1.jugadores.length; i++) {
            result.append(String.format("%-40s %s" , equipo1.jugadores[i] + " " + equipo1.jugadores[i].getPuntos() + " puntos",
                    equipo2.jugadores[i] + " " + equipo2.jugadores[i].getPuntos() + " puntos") + "\n");
        }

        System.out.println(result);
    }
}
