public class Manager {

    void setCoachDeportistas(Coach coach, Athlete[] athletes) {
        coach.setAthletes(athletes);
    }

    void setCoachDeportistas(Coach coach, Athlete athlete) {
        coach.setAthletes(athlete);
    }

    Coach createCoachDeportistas(String nombre, Athlete[] athletes) {
        return new Coach(nombre, athletes);
    }

    Coach createCoachDeportistas(String nombre, Athlete athlete) {
        return new Coach(nombre, athlete);
    }
}
