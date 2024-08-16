public class BasketballPlayer implements Deportista {
    String nombre;

    BasketballPlayer(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " se fue al gimnasio a hacer 100 tiros a la canasta");
    }

    @Override
    public void competir() {
        System.out.println(nombre + " se fue a otro gimnasio a jugar basket contra otros equipos");
    }

    @Override
    public void descansar() {
        System.out.println(nombre + " se fue a casa a descansar");
    }

}
