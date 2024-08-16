public class Main {
    public static void main(String[] args) {
        Jugador yo = new Jugador("Duilio", "12345");

        yo.conectarServidor("Duilio", "12345");

        //yo.desconectarServidor();

        Jugador j2 = new Jugador("Mauricio", "12345");
        j2.conectarServidor("Mauricio", "12345");
        //j2.desconectarServidor();

        System.out.println(Servidor.jugadores);
        yo.interactuarCon(j2);
        yo.desconectarServidor();
        System.out.println(Servidor.jugadores);
        j2.interactuarCon(yo);
        yo.conectarServidor("Duilio", "12345");
        if (j2.servidor == yo.servidor) {
            System.out.println("Este servidor es un Singelton");
        }
    }
}