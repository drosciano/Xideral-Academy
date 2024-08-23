import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    //Get the username[] from this link (gilter around 600 usernames from all of them)
    //https://github.com/danielmiessler/SecLists/blob/master/Usernames/xato-net-10-million-usernames.txt
    static String[] usernames = {"info", "admin", "2000", "michael", "NULL", "john", "david", "robert", "chris", "mike", "dave", "richard", "123456", "thomas", "steve", "mark", "andrew", "daniel", "george", "paul", "charlie", "dragon", "james", "qwerty", "martin", "master", "mail", "charles", "bill", "patrick", "1234", "peter", "shadow", "johnny", "hunter", "carlos", "jason", "tarrant", "alex", "brian", "steven", "scott", "edward", "joseph", "12345", "matthew", "justin", "natasha", "hammer", "anthony", "harley", "jack", "dallas", "dennis", "cameron", "gary", "monkey", "webmaster", "mustang", "ranger", "kevin", "jordan", "frank", "jeremy", "captain", "billy", "jeff", "freddy", "cowboy", "sales", "matt", "mickey", "eric", "tony", "jennifer", "joshua", "123", "killer", "spider", "superman", "iceman", "brandon", "jackson", "jeffrey", "bob", "calvin", "little", "scotty", "darren", "donald", "buster", "root", "fred", "timothy", "sparky", "snoopy", "philip", "net", "general", "coffee", "letmein", "contact", "love", "badboy", "kenneth", "stephen", "greg", "blue", "bigdog", "super", "boomer", "amateur", "bigdaddy", "gregory", "nathan", "batman", "junior", "phoenix", "scooter", "merlin", "austin", "doctor", "football", "chicago", "ronald", "maverick", "casper", "happy", "purple", "golden", "12345678", "andy", "player", "tigger", "chicken", "adam", "stuart", "dakota", "robbie", "prince", "falcon", "rocket", "marcus", "tiger", "orange", "rabbit", "hello", "dan", "cookie", "albert", "roberto", "morgan", "markus", "douglas", "simon", "pass", "chuck", "angel", "ronnie", "rick", "miller", "barney", "lucky", "rodney", "larry", "tom", "curtis", "scooby", "nick", "Michael", "big", "roland", "alan", "1111", "knight", "free", "skippy", "porsche", "phil", "allston", "phantom", "Robert", "bobby", "amanda", "baseball", "service", "maxwell", "jerry", "jake", "danny", "silver", "smokey", "samuel", "battery", "star", "hotdog", "bigboy", "jimmy", "peanut", "speedy", "ryan", "marc", "abc123", "oliver", "dog", "cunt", "stevie", "jonathan", "randy", "jones", "dreamer", "craig", "compaq", "hard", "michelle", "maddog", "antonio", "sunshine", "summer", "curious", "taylor", "adrian", "travis", "runner", "tommy", "thunder", "joe", "diamond", "Thomas", "terry", "gordon", "chad", "back", "action", "marlboro", "roger", "russell", "bubba", "johnson", "jackie", "skipper", "monster", "howard", "green", "blonde", "harry", "raymond", "arthur", "pepper", "francis", "brad", "banana", "bulldog", "king", "heather", "access", "111111", "alexis", "ashley", "lisa", "benjamin", "asian", "extreme", "bigman", "redman", "ping", "fire", "crazy", "andrea", "corvette", "carl", "theman", "sharon", "nicholas", "fantasy", "bradley", "aaron", "office", "boston", "stefan", "rich", "bailey", "shannon", "murray", "gabriel", "bobbat", "David", "frankie", "red", "cccccc", "peterso", "news", "angela", "aaaaaa", "heaven", "sandra", "house", "great", "ginger", "diablo", "bandit", "spencer", "rock", "power", "keith", "beach", "maggie", "graham", "baura", "sugar", "matrix", "hockey", "gandalf", "eddie", "sean", "bruce", "boy", "mister", "kelly", "hotrod", "crystal", "bobcat", "Richard", "shane", "nelson", "duffman", "dark", "buddy", "member", "ford", "chester", "teen", "melissa", "mario", "ken", "chance", "rocky", "marco", "jose", "golfer", "cooper", "andreas", "Stone55", "secret", "eugene", "henry", "billybob", "bigcock", "barry", "Daniel", "1234567", "todd", "stanley", "nicole", "josh", "brown", "william", "bryan", "George", "teens", "stewart", "kitten", "jacob", "hank", "camaro", "trevor", "michel", "duncan", "doggie", "chen", "support", "pete", "monica", "freedom", "animal", "angels", "aaaa", "simple", "sammy", "fernando", "bear", "jimbob", "bambam", "baby", "6969", "tiffany", "sun", "jasper", "James", "sasha", "qwer", "college", "asdasd", "joey", "jessica", "debbie", "christian", "badger", "rachel", "jim", "harvey", "doug", "alpha", "11111", "soccer", "chelsea", "bigred", "bbbb", "please", "pierre", "pascal", "panther", "flower", "dude", "anna", "sarah", "Andrew", "kyle", "flash", "buddha", "billyboy", "barbara", "samantha", "kenny", "jimbo", "good", "danielle", "brendan", "sandman", "julie", "johnboy", "ferrari", "andre", "derek", "chan", "buffalo", "bitches", "tim", "qwert", "phillip", "movie", "jester", "donnie", "clinton", "sam", "harrison", "bishop", "Black", "toyota", "gateway", "cool", "cherry", "candy", "bigguy", "bernie", "ben", "robin", "duke", "brent", "american", "alberto", "Steve", "smith", "raider", "princess", "magic", "homer", "reddog", "lawrence", "ladies", "jerome", "flipper", "drew", "arnold", "apple", "allen", "tomcat", "song", "parker", "latin", "julian", "jayjay", "gerald", "french", "fireman", "shawn", "mikey", "miguel", "harold", "carmen", "bernard", "2222", "rusty", "roman", "ricardo", "jaguar", "driver", "smooth", "shorty", "short", "richie", "private", "pedro", "paris", "pamela", "neil", "nan", "nai", "fender", "dexter", "chevy", "brazil", "bigone", "august", "reggie", "norman", "nasty", "fish", "eagle", "digger", "tucker", "murphy", "madmax", "luke", "linda", "jamie", "herman", "fan", "pie", "nao", "maximus", "marine", "maria", "denise", "davids", "Martin", "russian", "ricky", "maurice", "gerard", "daddy", "sticky", "san", "photo", "magnum", "london", "leather", "juice", "guest", "felix", "dolphin", "dale", "cheese", "blake", "Smith", "nang", "malcolm", "chi", "bronco", "brandy", "shaved", "sergio", "marcel", "kris", "golf", "eagles", "dannyboy", "content", "cobra", "chocolate", "bigmac", "angelo", "anders", "ren", "ralph", "marvin", "internet", "huge", "florida", "digital", "22222", "tang", "stacey", "shaggy", "scorpion", "scorpio", "samson", "rebecca", "randall", "ran", "nothing", "long", "leonard", "horse", "chang", "carter", "awesome", "apollo", "999999", "testing", "sophie", "japan", "giant", "brett", "beavis", "bbbbbb", "alfred", "John", "stratfor", "snowman", "sandy", "rooster", "pontiac", "latino", "karl", "family", "elvis", "cowboys", "cannon", "bart", "Charlie", "222222", "talk", "slayer", "rob", "marshall", "logan", "karen", "hungry", "don", "dominic", "tan", "stars", "smitty", "rainbow", "justme", "hitman", "freddie", "coyote", "classic", "bigmike", "tomtom", "perfect", "outlaw", "leslie", "colin", "breathe", "111", "spycams", "shan", "run", "random", "pink", "pan", "oscar", "manuel", "gunner", "flyboy", "fang", "dreams", "damien", ""};
    //Team[] that has the values of the enum of Teams
    static Team[] teams = Team.values();
    public static void main(String[] args) {
        //Make a supplier to create random Players
        Supplier<Player> playerGenerator = () -> {
            String username = usernames[(int)(Math.random()*usernames.length)];
            int gamesPlayed = (int)(Math.random()*1000) + 1;
            int gamesWon = (int)(Math.random()*gamesPlayed);
            double salary = (double)(int)(Math.random()*15000 + 5000);
            Team team = teams[(int)(Math.random()*teams.length)];
            return new Player(username, gamesPlayed, gamesWon, salary, team);
        };

        //Create 200 random Players
        Player[] players = new Player[200];
        IntStream.range(0, 200).forEach(i -> players[i] = playerGenerator.get());

        //Make the Stream of an Array
        Stream<Player> playerStream = Arrays.stream(players);

        //Get the Team with the best salary average
        Optional<Team> bestAvgTeam = playerStream
                .collect(groupingBy(Player::getTeam, Collectors.averagingDouble(Player::getSalary)))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        //Now that we have the team with the best salary average now get the Player with the highest salary
        Optional<Player> bestPaidPlayer;
        final Optional<Player>[] temp = new Optional[]{Optional.empty()};

        //Because the Team is an Optional we need to use ifPresent()
        bestAvgTeam.ifPresent(team -> {
            Optional<Player> bstPaid = Arrays.stream(players)
                    .filter(x -> x.getTeam() == team)
                    .max((x, y) -> (int)((x.getSalary()-y.getSalary())));

            temp[0] = bstPaid;
        });
        bestPaidPlayer = temp[0];

        //order the players in descending order according to the salary
        //This is just to corroborate that the Best Payed Player in the best paid team is not necessarily the best paid player overall
        Arrays.sort(players, (x,y) -> (int)(y.getSalary() - x.getSalary()));
        System.out.println(Arrays.toString(players));

        //Print the result
        System.out.println(bestPaidPlayer);

    }
}