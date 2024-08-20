public class TennisPlayer implements Athlete {
    String name;

    TennisPlayer(String nombre) {
        this.name = nombre;
    }

    @Override
    public void train() {
        System.out.println(name + " se fue a las canchas de tenis a hacer 100 saques de potencia");
    }

    @Override
    public void compete() {
        System.out.println(name + " se fue a otras canchas a jugar contra otras personas");
    }

    @Override
    public void rest() {
        System.out.println(name + " se fue a casa a descansar");
    }
}
