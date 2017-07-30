package com.sarryromain.metacriticapi.review;

import com.sarryromain.metacriticapi.core.interfaces.IMetacriticAPI;
import com.sarryromain.metacriticapi.core.MetacriticPage;

import java.util.Date;
import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticMovie extends MetacriticReview {
    public static String URL_BASE = IMetacriticAPI.URL_BASE + "movie/";

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

    public MetacriticMovie() {
        super();
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
    }

    List<String> actors;

    String director;

    List<String> genres;

    String rating;

    Date releaseDate;

    String runtime;

    String score;

    String summary;

    String title;

    String trailer;

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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
