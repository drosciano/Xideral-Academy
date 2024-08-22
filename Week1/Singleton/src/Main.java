public class Main {
    public static void main(String[] args) {
        Jugador yo = new Jugador("Duilio", "12345");
        Jugador j2 = new Jugador("Mauricio", "12345");

        //INTERACTUAR CON JUGADOR DESCONECTADO
        yo.conectarServidor("Duilio", "12345", "contraseña");
        yo.interactuarCon(j2);

        //INTENTAR CONECTAR CON EL SERVIDOR CON UNA CONTRASEÑA ERRONEA
        j2.conectarServidor("Mauricio", "12345", "contrasena");

        //INTERACTUAR CON JUGADOR CONECTADO
        j2.conectarServidor("Mauricio", "12345", "contraseña");
        yo.interactuarCon(j2);

        //INTERACTUAR ESTANDO DESCONECTADO
        yo.desconectarServidor();
        yo.interactuarCon(j2);

        //CORROBORAR QUE AMBOS ESTEN USANDO LA MISMA INSTANCIA DE SERVIDOR
        yo.conectarServidor("Duilio", "12345", "contraseña");
        if (yo.getServidor() == j2.getServidor()) {
            System.out.println("Se ha usado el Singelton con exito");
        }
    }
}