import Operaciones.*;
import Escuela.*;

public class Main {
    public static void main(String[] args) {

        Object[] o = {
          "Hola",
          Integer.valueOf(3),
          new Suma(8, 5)
        };

        //Operaciones
        OperacionAbs[] operaciones = {
                new Suma(8, 5),
                new Resta(8, 5),
                new Multi(8, 5),
                new Division(8, 5),
                new Exponencial(8, 5)
        };
        for (Operacion ope : operaciones) {
            System.out.println(ope);
            System.out.println(ope.ejecuta());
        }

        //Escuela
        Estudiante[] estudiantes = {
            new Estudiante("Mauricio", 21),
            new Estudiante("Javier", 23),
            new Estudiante("Luis", 20),
            new Estudiante("Emiliando", 22)
        };

        for (Estudiante e : estudiantes) {
            System.out.println(e);
            System.out.println(Estudiante.getContador());
        }

        for (var x : o) {
            System.out.println(x);
        }
    }
}