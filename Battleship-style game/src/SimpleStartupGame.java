import java.util.Random;

public class SimpleStartupGame {

    public static void main(String[] args) {
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        SimpleStartup startup = new SimpleStartup();

        int random = new Random().nextInt(5);

        int[] locations = {random, random + 1, random + 2};
        startup.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive) {

            int guess = helper.getUserInput("enter a number");
            String result = startup.checkYourself(guess);
            numOfGuesses++;

            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}
