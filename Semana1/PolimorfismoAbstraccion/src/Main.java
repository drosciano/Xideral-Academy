public class Main {
    public static void main(String[] args) {
        Jugador[] eq1 = {
                new PointGuard("Luka Doncic", 25, 77, 48.7, 38.2),
                new ShootingGuard("Kyrie Irving", 32, 11, 49.7, 41.1),
                new SmallForward("Klay Thompson", 34, 11, 43.2, 38.7),
                new PowerForward("P.J. Washington", 25, 25, 43.7, 32),
                new Center("Daniel Gafford", 25, 21, 72.5, 0)
        };
        Jugador[] eq2 = {
                new PointGuard("Stephen Curry", 36, 30, 45, 40.8),
                new ShootingGuard("Brandin Podziemski", 21, 2, 45.4, 38.5),
                new SmallForward("Andrew Wiggins", 29, 22, 45.3, 35.8),
                new PowerForward("Draymond Green", 34, 23, 49.7, 39.5),
                new Center("Trayce Jackson-Davis", 24, 32, 70.2, 0)
        };
        Equipo mavericks = new Equipo("Dallas Mavericks", eq1);
        Equipo warriors = new Equipo("Golden State Warriors", eq2);
        Partido partido1 = new Partido(mavericks, warriors);


        System.out.print(partido1);
        partido1.simularPartido();
    }

}