enum Team {
    Team1,
    Team2,
    Team3,
    Team4,
    Team5,
    Team6,
    Team7,
    Team8
}

public class Player {
    String username;
    int gamesPlayed;
    int gamesWon;
    double salary;
    Team team;

    public Player(String username, int gamesPlayed, int gamesWon, double salary, Team team) {
        this.username = username;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.salary = salary;
        this.team = team;
    }

    Player() {

    }

    public Team getTeam() {
        return team;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public double getSalary() {
        return salary;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesWon=" + gamesWon +
                ", salary=" + salary +
                ", team=" + team +
                '}';
    }
}
