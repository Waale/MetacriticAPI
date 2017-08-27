package metacriticapi.review.service;

import metacriticapi.review.MetacriticGame;
import metacriticapi.review.enums.MetacriticGamePlatform;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

/**
 * Created by Romain on 19/08/2017.
 */
public class MetacriticGameServiceTest {
    @Test
    public void gameTest() {
        MetacriticGameService service = new MetacriticGameService();
        MetacriticGame game = service.getByTitle("The Elder Scrolls V : Skyrim", MetacriticGamePlatform.PC);

        assertNotNull(game);
        assertNotNull(game.getTitle());
        assertNotNull(game.getScore());
        assertNotNull(game.getUserScore());
        assertNotNull(game.getReleaseDate());
        assertNotNull(game.getSummary());
        assertNotNull(game.getGenres());
        assertFalse(game.getGenres().isEmpty());
        assertNotNull(game.getRating());
        assertNotNull(game.getTrailer());
        assertNotNull(game.getDeveloper());
        assertNotNull(game.getGamePlatform());

        /*System.out.println("GAME TEST");
        System.out.println("Title : " + game.getTitle());
        System.out.println("Score : " + game.getScore());
        System.out.println("User Score : " + game.getUserScore());
        System.out.println("Release Date : " + game.getReleaseDate());
        System.out.println("Summary : " + game.getSummary());
        System.out.print("Genres :");
        for (String genre : game.getGenres()) {
            System.out.print(" " + genre);
        }
        System.out.println();
        System.out.println("Rating : " + game.getRating());
        System.out.println("Trailer : " + game.getTrailer());
        System.out.println("Developer : " + game.getDeveloper());
        System.out.println("Platform : " + game.getGamePlatform().getPlatform());*/
    }

    @Test
    public void gameSearchTest() {
        MetacriticGameService service = new MetacriticGameService();
        List<String> games = service.search("Bioshock");

        assertNotNull(games);
        assertFalse(games.isEmpty());
        assertTrue(games.contains("BioShock Infinite"));

/*        for (String game : games) {
            System.out.println(game);
        }*/
    }
}
