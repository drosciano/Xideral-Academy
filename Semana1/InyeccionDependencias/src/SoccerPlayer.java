public class SoccerPlayer implements Deportista {
    String nombre;

    SoccerPlayer(String nombre) {
        this.nombre  = nombre;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " se fue al campo de futbol a practicar su tiro con el pie menos dominante");
    }

    @Override
    public void competir() {
        System.out.println(nombre + " se fue a otro campo a jugar futbol contra otros equipos");
    }

    @Override
    public void descansar() {
        System.out.println(nombre + " se fue a casa a descansar");
    }
}
