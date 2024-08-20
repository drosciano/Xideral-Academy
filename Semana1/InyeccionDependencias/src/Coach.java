public class Coach {
    Athlete[] athletes;
    String name;


    Coach(String name, Athlete[] athletes) {
        this.name = name;
        this.athletes = athletes;
    }

    Coach(String name, Athlete athlete) {
        this.name = name;
        this.athletes = new Athlete[] {athlete};
    }

    Coach(String name) {
        this.name = name;
        this.athletes = new Athlete[]{};
    }

    public void setAthletes(Athlete[] athletes) {
        this.athletes = athletes;
    }

    public void setAthletes(Athlete athlete) {
        this.athletes = new Athlete[] {athlete};
    }

    public void goTrain() {
        for(Athlete d : this.athletes) {
            d.train();
        }
    }

    public void goRest() {
        for (Athlete d : this.athletes) {
            d.rest();
        }
    }

    public void goCompete() {
        for (Athlete d : this.athletes) {
            d.compete();
        }
    }
}
