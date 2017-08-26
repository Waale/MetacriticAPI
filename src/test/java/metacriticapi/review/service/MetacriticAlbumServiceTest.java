package metacriticapi.review.service;

import metacriticapi.review.MetacriticAlbum;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Romain on 20/08/2017.
 */
public class MetacriticAlbumServiceTest {
    @Test
    public void albumTest() {
        MetacriticAlbumService service = new MetacriticAlbumService();
        MetacriticAlbum album = service.getByTitleAndAuthor("The Eminem Show", "Eminem");
        System.out.println("ALBUM TEST");
        System.out.println("Title : " + album.getTitle());
        System.out.println("Score : " + album.getScore());
        System.out.println("Release Date : " + album.getReleaseDate());
        System.out.println("Summary : " + album.getSummary());
        System.out.print("Genres :");
        for (String genre : album.getGenres()) {
            System.out.print(" " + genre);
        }
        System.out.println();
        System.out.println("User Score : " + album.getUserScore());
        System.out.println("Label : " + album.getLabel());
        System.out.print("Tracks :");
        for (Map.Entry<String, String> track : album.getTracks().entrySet()) {
            System.out.print(" " + track.getKey() + " - " + track.getValue());
        }
        System.out.println();
    }

    @Test
    public void albumSearchTest() {
        MetacriticAlbumService service = new MetacriticAlbumService();
        List<String> albums = service.search("Prism");
        for (String album : albums) {
            System.out.println(album);
        }
    }
}
