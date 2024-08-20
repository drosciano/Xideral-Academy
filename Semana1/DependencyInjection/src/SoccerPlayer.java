public class SoccerPlayer implements Athlete {
    String name;

    SoccerPlayer(String name) {
        this.name = name;
    }

    @Override
    public void train() {
        System.out.println(name + " se fue al campo de futbol a practicar su tiro con el pie menos dominante");
    }

    @Override
    public void compete() {
        System.out.println(name + " se fue a otro campo a jugar futbol contra otros equipos");
    }

    @Override
    public void rest() {
        System.out.println(name + " se fue a casa a descansar");
    }
}
