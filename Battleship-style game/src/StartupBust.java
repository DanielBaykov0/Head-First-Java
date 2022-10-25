import java.util.ArrayList;

public class StartupBust {
    private int numOfGuesses = 0;
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<>();

    private void setUpGame() {
        Startup startup1 = new Startup("poniez");
        Startup startup2 = new Startup("hacqi");
        Startup startup3 = new Startup("cabista");
        startups.add(startup1);
        startups.add(startup2);
        startups.add(startup3);

        System.out.println("Your goal is to sing three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3);
            startup.setLocationCells(newLocation);
        }
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (Startup startup : startups) {
            result = startup.checkYourself(userGuess);

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startups.remove(startup);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    private void startPlaying() {
        while (!startups.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startPlaying();

    }
}
