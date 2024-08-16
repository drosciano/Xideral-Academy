public class TaeKwonDoPlayer implements Deportista {
    String nombre;

    TaeKwonDoPlayer(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " se fue al Doyang a practicar nuevas combinaciones de patadas");
    }

    @Override
    public void competir() {
        System.out.println(nombre + " se fue a otro Doyang a competir contra otras personas");
    }

    @Override
    public void descansar() {
        System.out.println(nombre + " se fue a casa a descansar");
    }
}
