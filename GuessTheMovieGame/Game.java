import java.util.TreeSet;

public class Game {
    private String movieTitle;
    private String movieTitleLowerCase;
    private StringBuilder hiddenTitle;
    private String wrongLetters;
    private TreeSet<Character> guessedLetters;
    private TreeSet<Character> lettersToGuess;
    private int points;
    private boolean hasWon_;

    Game(String movieTitle) {
        this.movieTitle = movieTitle;
        movieTitleLowerCase = movieTitle.toLowerCase();
        hiddenTitle = new StringBuilder();
        wrongLetters = new String();
        guessedLetters = new TreeSet<>();
        lettersToGuess = new TreeSet<>();
        points = 0;
        hasWon_ = false;

        for (int i = 0; i < this.movieTitle.length(); i++) {
            hiddenTitle.append("_");
            if (movieTitle.charAt(i) != ' ') lettersToGuess.add(movieTitle.charAt(i));
        }
    }

    private boolean hasAlreadyGuessed(Character guess) {
        return guessedLetters.contains(guess);
    }

    private void updateGameStatus(Character guess) {
        guessedLetters.add(guess);
        lettersToGuess.remove(guess);
        if (lettersToGuess.isEmpty()) hasWon_ = true;
    }

    public void nextGuess() {
        System.out.println("You're guessing: "
                            + hiddenTitle
                            + "\nYou have guessed (" + points + ") wrong letters: "
                            + wrongLetters
                            + "\nGuess a letter: ");
    }

    public void checkGuess(char guess) {
        if (hasAlreadyGuessed(guess)) {
            System.out.println("You've already guessed the letter " + guess + ". Try another letter.");
        } else {
            int index = movieTitleLowerCase.indexOf(guess);
            if (index == -1) {
                points++;
                wrongLetters += guess + " ";
            } else {
                while (index >= 0) {
                    hiddenTitle.setCharAt(index, movieTitle.charAt(index));
                    index = movieTitleLowerCase.indexOf(guess, index + 1);
                }
                updateGameStatus(guess);
            }
        }
    }

    public boolean isPlaying() {
        return points < 10 && !hasWon();
    }

    public boolean hasWon() {
        return hasWon_;
    }

    public void endGame() {
        String message = new String();

        if (hasWon_) {
            message += "You're guessing: " + hiddenTitle + "\nCORRECT... YOU WIN!!!";
        } else {
            message += "You have guessed (10) wrong letters.\nGAME OVER... YOU LOSE!!!\nThe movie was: " + movieTitle;
        }

        System.out.println(message);
    }

}



