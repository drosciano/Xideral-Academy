public class BasketballPlayer implements Athlete {
    String name;

    BasketballPlayer(String nombre) {
        this.name = nombre;
    }

    @Override
    public void train() {
        System.out.println(name + " se fue al gimnasio a hacer 100 tiros a la canasta");
    }

    @Override
    public void compete() {
        System.out.println(name + " se fue a otro gimnasio a jugar basket contra otros equipos");
    }

    @Override
    public void rest() {
        System.out.println(name + " se fue a casa a descansar");
    }

}
