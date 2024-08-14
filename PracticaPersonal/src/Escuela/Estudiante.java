package Escuela;

public class Estudiante {
    //Encapsular usando private
    private String nombre;
    private int edad;
    private static int contador; //Variable de Clase


    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        contador++;
    }

    @Override
    public String toString() {
        return "Estudiante; [nombre = " + nombre + ", edad = " + edad + "]";
    }

    public static int getContador() {
        return contador;
    }
}
