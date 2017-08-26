package metacriticapi.review;

import metacriticapi.core.MetacriticAPI;
import metacriticapi.core.MetacriticPage;

import java.util.Date;
import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticMovie extends MetacriticReview {
    public static String URL_BASE = MetacriticAPI.URL_BASE + "movie/";

    public static String URL_SEARCH = MetacriticAPI.URL_SEARCH + "movie/";

    private static final String ACTORS_SELECTOR = ".summary_cast span:not(.label) a";

    private static final String DIRECTOR_SELECTOR = ".director a span";

    private static final String GENRES_SELECTOR = ".genres span:not(.label) span";

    private static final String RATING_SELECTOR = ".rating span:not(.label)";

    private static final String RELEASE_DATE_SELECTOR = ".release_date span:not(.label)";

    private static final String RUNTIME_SELECTOR = ".runtime span:not(.label)";

    private static final String SCORE_SELECTOR = ".metascore_anchor span";

    private static final String SUMMARY_SELECTOR = ".summary_deck .blurb_expanded";

    private static final String TITLE_SELECTOR = ".product_page_title h1";

    private static final String TRAILER_SELECTOR = ".product_header #video_holder_wrapper";

    private static final String USER_SCORE_SELECTOR = ".users_col div.user";

    public MetacriticMovie() {
        super();
    }

    public MetacriticMovie(Date releaseDate, String score, String title, String userScore) {
        super(releaseDate, score, title, userScore);
    }

    public MetacriticMovie(MetacriticPage page) {
        super(page);
        setTitle(page.getFieldAsText(TITLE_SELECTOR));
        setScore(page.getFieldAsText(SCORE_SELECTOR));
        setReleaseDate(page.getFieldAsDate(RELEASE_DATE_SELECTOR));
        setActors(page.getFieldsAsText(ACTORS_SELECTOR));
        setSummary(page.getFieldAsText(SUMMARY_SELECTOR));
        setDirector(page.getFieldAsText(DIRECTOR_SELECTOR));
        setGenres(page.getFieldsAsText(GENRES_SELECTOR));
        setRating(page.getFieldAsText(RATING_SELECTOR));
        setRuntime(page.getFieldAsText(RUNTIME_SELECTOR));
        setTrailer(page.getField(TRAILER_SELECTOR).attr("data-mcvideourl"));
        setUserScore(page.getFieldAsText(USER_SCORE_SELECTOR));
    }

    private List<String> actors;

    private String director;

    private String runtime;

    public void addActor(String actor) {
        actors.add(actor);
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
}
