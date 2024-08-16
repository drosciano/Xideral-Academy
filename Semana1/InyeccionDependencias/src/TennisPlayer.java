import java.awt.geom.FlatteningPathIterator;

public class TennisPlayer implements Deportista {
    String nombre;

    TennisPlayer(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " se fue a las canchas de tenis a hacer 100 saques de potencia");
    }

    @Override
    public void competir() {
        System.out.println(nombre + " se fue a otras canchas a jugar contra otras personas");
    }

    @Override
    public void descansar() {
        System.out.println(nombre + " se fue a casa a descansar");
    }
}
