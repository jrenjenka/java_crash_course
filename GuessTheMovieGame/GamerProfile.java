import java.util.Scanner;

public class GamerProfile {
    private boolean isPlaying_;
    private int scoreWin;
    private int scoreLose;

    GamerProfile() {
        isPlaying_ = true;
        scoreWin = 0;
        scoreLose = 0;
    }

    public void startPlaying() {
        System.out.println("I randomly pick a movie title.\n"
                + "Try to figure out the movie by guessing one letter at a time.\n"
                + "READY? GO!\n");
    }

    public void setScore(boolean hasWon) {
        if (hasWon) {
            scoreWin++;
        } else {
            scoreLose++;
        }
    }

    public void setNextGame() {
        char playerAnswer = ' ';

        do {
            System.out.println("Do you want to play again? (y/n): ");

            Scanner scanner = new Scanner(System.in);
            playerAnswer = Character.toLowerCase(scanner.next().charAt(0));

            isPlaying_ = playerAnswer == 'y' ? true : false;

        } while (playerAnswer != 'y' && playerAnswer != 'n');
    }

    public boolean isPlaying() {
        return isPlaying_;
    }

    public void stopPlaying() {
        System.out.println("TOTAL SCORE...\n"
                + "You've correctly guessed: " + scoreWin + " movie(s)\n"
                + "You haven't guessed: " + scoreLose + " movie(s)\n"
                + "GAME OVER. SEE YOU NEXT TIME!");
    }
}
