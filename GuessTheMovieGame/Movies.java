import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Movies {
    private ArrayList<String> movies;

    Movies(String fileName) throws FileNotFoundException {
        movies = new ArrayList<>();

        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            this.movies.add(fileScanner.nextLine());
        }
    }

    public String getMovieTitle() {
        int randomIndex = (int) (Math.random() * movies.size());
        return movies.get(randomIndex);
    }

}
