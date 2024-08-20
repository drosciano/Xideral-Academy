public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Athlete[] athletes1 = {
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

        Coach coach1 = manager.createCoachDeportistas("Luis", athletes1);
        coach1.goTrain();
        coach1.goCompete();
        coach1.goRest();

        Athlete[] athletes2 = {
                new TennisPlayer("Josue"),
                new BasketballPlayer("Pato"),
                new SoccerPlayer("Julien")
        };

        coach1.setAthletes(athletes2);
        coach1.goTrain();
        coach1.goCompete();
        coach1.goRest();
    }
}