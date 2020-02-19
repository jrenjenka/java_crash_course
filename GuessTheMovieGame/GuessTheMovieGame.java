import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GuessTheMovieGame {
    public static void main(String[] args) {
        try {
            int scoreWin = 0;
            int scoreLose = 0;

            ArrayList<String> movies = new ArrayList<String>();

            File file = new File("movies.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                movies.add(fileScanner.nextLine());
            }

            System.out.println("I randomly pick a movie title.");
            System.out.println("Try to figure out the movie by guessing one letter at a time.");
            System.out.println("READY? GO!\n");

            boolean isPlaying = true;

            while (isPlaying) {
                int randomIndex = (int) (Math.random() * movies.size());
                String movieTitle = movies.get(randomIndex);

                String movieTitleLowerCase = movieTitle.toLowerCase();
                int lettersToGuessCounter = movieTitle.length();

                StringBuilder hiddenTitle = new StringBuilder();

                for (int i = 0; i < movieTitleLowerCase.length(); i++) {
                    hiddenTitle.append("_");
                    if (movieTitleLowerCase.charAt(i) == ' ') lettersToGuessCounter--;
                }

                int points = 0;
                String wrongLetters = new String();
                boolean hasWon = false;

                Scanner inputScanner = new Scanner(System.in);

                while (points < 10) {
                    System.out.println("You're guessing: " + hiddenTitle);
                    System.out.println("You have guessed (" + points + ") wrong letters: " + wrongLetters);
                    System.out.println("Guess a letter: ");

                    char guess = Character.toLowerCase((inputScanner.next().charAt(0)));

                    int index = movieTitleLowerCase.indexOf(guess);
                    if (index == -1) {
                        points++;
                        wrongLetters += guess + " ";
                    } else {
                        while (index >= 0) {
                            hiddenTitle.setCharAt(index, movieTitle.charAt(index));
                            index = movieTitleLowerCase.indexOf(guess, index + 1);
                            lettersToGuessCounter--;
                        }
                    }

                    if (lettersToGuessCounter == 0) {
                        hasWon = true;
                        break;
                    }
                }

                if (hasWon) {
                    System.out.println("You're guessing: " + hiddenTitle);
                    System.out.println("CORRECT... YOU WIN!!!");
                    scoreWin++;
                } else {
                    System.out.println("You have guessed (10) wrong letters " + lettersToGuessCounter);
                    System.out.println("GAME OVER... YOU LOSE!!!");
                    System.out.println("The movie was: " + movieTitle);
                    scoreLose++;
                }

                char playerAnswer = ' ';
                do {
                    System.out.println("Do you want to play again? (y/n): ");
                    Scanner scanner = new Scanner(System.in);
                    playerAnswer = Character.toLowerCase(scanner.next().charAt(0));
                    isPlaying = playerAnswer == 'y' ? true : false;
                } while (playerAnswer != 'y' && playerAnswer != 'n');

            }

            System.out.println("TOTAL SCORE...");
            System.out.println("You've correctly guessed: " + scoreWin + " movie(s)");
            System.out.println("You haven't guessed: " + scoreLose + " movie(s)");
            System.out.println("GAME OVER. SEE YOU NEXT TIME!");

        } catch (FileNotFoundException e){
            System.out.println("File not valid");
        }
    }
}
