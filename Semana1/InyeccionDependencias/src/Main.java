public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Deportista[] deportistas1 = {
                new BasketballPlayer("Javier"),
                new TennisPlayer("Luis"),
                new TennisPlayer("Gilberto"),
                new TaeKwonDoPlayer("Duilio"),
                new TaeKwonDoPlayer("Monica"),
                new SoccerPlayer("Diego"),
                new BasketballPlayer("Eduardo"),
                new SoccerPlayer("Mauricio"),
                new TaeKwonDoPlayer("Antonio")
        };

        Coach coach1 = manager.createCoachDeportistas("Luis", deportistas1);
        coach1.ponerEntrenamiento();
        coach1.ponerCompetir();
        coach1.ponerDescansar();

        Deportista[] deportistas2 = {
                new TennisPlayer("Josue"),
                new BasketballPlayer("Pato"),
                new SoccerPlayer("Julien")
        };

        coach1.setDeportistas(deportistas2);
        coach1.ponerEntrenamiento();
        coach1.ponerCompetir();
        coach1.ponerDescansar();
    }
}