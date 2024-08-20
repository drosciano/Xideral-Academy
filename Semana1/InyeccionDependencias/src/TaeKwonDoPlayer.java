public class TaeKwonDoPlayer implements Athlete {
    String name;

    TaeKwonDoPlayer(String nombre) {
        this.name = nombre;
    }

    @Override
    public void train() {
        System.out.println(name + " se fue al Doyang a practicar nuevas combinaciones de patadas");
    }

    @Override
    public void compete() {
        System.out.println(name + " se fue a otro Doyang a competir contra otras personas");
    }

    @Override
    public void rest() {
        System.out.println(name + " se fue a casa a descansar");
    }
}
