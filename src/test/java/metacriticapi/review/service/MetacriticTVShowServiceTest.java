package metacriticapi.review.service;

import metacriticapi.review.MetacriticTVShow;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticTVShowServiceTest {
    @Test
    public void tvShowTest() {
        MetacriticTVShowService service = new MetacriticTVShowService();
        MetacriticTVShow tvShow = service.getByTitle("Game Of Thrones");

        assertNotNull(tvShow);
        assertNotNull(tvShow.getTitle());
        assertNotNull(tvShow.getScore());
        assertNotNull(tvShow.getUserScore());
        assertNotNull(tvShow.getReleaseDate());
        assertNotNull(tvShow.getActors());
        assertFalse(tvShow.getActors().isEmpty());
        assertNotNull(tvShow.getSummary());
        assertNotNull(tvShow.getCreators());
        assertFalse(tvShow.getCreators().isEmpty());
        assertNotNull(tvShow.getGenres());
        assertFalse(tvShow.getGenres().isEmpty());
        assertNull(tvShow.getRating());
        assertNotNull(tvShow.getTrailer());
        assertNotNull(tvShow.getSeasons());

        /*System.out.println("TV SHOW TEST");
        System.out.println("Title : " + tvShow.getTitle());
        System.out.println("Score : " + tvShow.getScore());
        System.out.println("User Score : " + tvShow.getUserScore());
        System.out.println("Release Date : " + tvShow.getReleaseDate());
        System.out.print("Actors :");
        for (String actor : tvShow.getActors()) {
            System.out.print(" " + actor);
        }
        System.out.println();
        System.out.println("Summary : " + tvShow.getSummary());
        System.out.print("Creators :");
        for (String creator : tvShow.getCreators()) {
            System.out.print(" " + creator);
        }
        System.out.println();
        System.out.print("Genres :");
        for (String genre : tvShow.getGenres()) {
            System.out.print(" " + genre);
        }
        System.out.println();
        System.out.println("Rating : " + tvShow.getRating());
        System.out.println("Trailer : " + tvShow.getTrailer());
        System.out.println("Seasons : " + tvShow.getSeasons());*/
    }

    @Test
    public void tvShowSearchTest() {
        MetacriticTVShowService service = new MetacriticTVShowService();
        List<String> tvShows = service.search("How I Met Your Mother");

        assertNotNull(tvShows);
        assertFalse(tvShows.isEmpty());
        assertTrue(tvShows.contains("How I Met Your Mother"));

/*        for (String tvShow : tvShows) {
            System.out.println(tvShow);
        }*/
    }
}
