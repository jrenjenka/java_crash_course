import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Movies movies = new Movies("movies.txt");
            GamerProfile profile = new GamerProfile();

            profile.startPlaying();

            while (profile.isPlaying()) {
                Game newGame = new Game(movies.getMovieTitle());

                Scanner inputScanner = new Scanner(System.in);

                while (newGame.isPlaying()) {
                    newGame.nextGuess();
                    char guess = Character.toLowerCase((inputScanner.next().charAt(0)));
                    newGame.checkGuess(guess);
                }

                newGame.endGame();
                profile.setScore(newGame.hasWon());
                profile.setNextGame();
            }

            profile.stopPlaying();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
