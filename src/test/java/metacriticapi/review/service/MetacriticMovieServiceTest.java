package metacriticapi.review.service;

import metacriticapi.review.MetacriticMovie;
import org.junit.Test;

import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticMovieServiceTest {
    @Test
    public void movieTest() {
        MetacriticMovieService service = new MetacriticMovieService();
        MetacriticMovie movie = service.getByTitle("Assassin's Creed");
        System.out.println("MOVIE TEST");
        System.out.println("Title : " + movie.getTitle());
        System.out.println("Score : " + movie.getScore());
        System.out.println("User Score : " + movie.getUserScore());
        System.out.println("Release Date : " + movie.getReleaseDate());
        System.out.print("Actors :");
        for (String actor : movie.getActors()) {
            System.out.print(" " + actor);
        }
        System.out.println();
        System.out.println("Summary : " + movie.getSummary());
        System.out.println("Director : " + movie.getDirector());
        System.out.print("Genres :");
        for (String genre : movie.getGenres()) {
            System.out.print(" " + genre);
        }
        System.out.println();
        System.out.println("Rating : " + movie.getRating());
        System.out.println("Runtime : " + movie.getRuntime());
        System.out.println("Trailer : " + movie.getTrailer());
    }

    @Test
    public void movieSearchTest() {
        MetacriticMovieService service = new MetacriticMovieService();
        List<String> movies = service.search("300");
        for (String movie : movies) {
            System.out.println(movie);
        }
    }
}
