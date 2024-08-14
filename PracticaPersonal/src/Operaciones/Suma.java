package Operaciones;

//Operaciones.Suma is-a Operaciones.OperacionAbs, y Operaciones.OperacionAbs is-a Operaciones.Operacion
//Por lo tanto Operaciones.Suma is-a Operaciones.Operacion
public class Suma extends OperacionAbs {

    public Suma(int x, int y) {
        super(x, y);
    }

    @Override
    public int ejecuta() {
        return x + y;
    }
}
