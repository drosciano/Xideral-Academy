public class Manager {

    void setCoachDeportistas(Coach coach, Deportista[] deportistas) {
        coach.setDeportistas(deportistas);
    }

    void setCoachDeportistas(Coach coach, Deportista deportista) {
        coach.setDeportistas(deportista);
    }

    Coach createCoachDeportistas(String nombre, Deportista[] deportistas) {
        return new Coach(nombre, deportistas);
    }

    Coach createCoachDeportistas(String nombre, Deportista deportista) {
        return new Coach(nombre, deportista);
    }
}
