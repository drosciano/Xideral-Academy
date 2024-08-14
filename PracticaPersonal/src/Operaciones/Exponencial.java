package Operaciones;

public class Exponencial extends OperacionAbs {

    public Exponencial(int x, int y) {
        super(x, y);
    }

    @Override
    public int ejecuta() {
        return (int)Math.pow(x, y);
    }
}
