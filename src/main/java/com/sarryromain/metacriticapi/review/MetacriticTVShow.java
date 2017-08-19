package com.sarryromain.metacriticapi.review;

import com.sarryromain.metacriticapi.core.MetacriticPage;
import com.sarryromain.metacriticapi.core.interfaces.IMetacriticAPI;

import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticTVShow extends MetacriticReview {
    public static String URL_BASE = IMetacriticAPI.URL_BASE + "tv/";

    public static String URL_SEARCH = IMetacriticAPI.URL_SEARCH + "tv/";

    private static final String ACTORS_SELECTOR = ".summary_detail.product_credits .data span span";

    private static final String CREATORS_SELECTOR = ".summary_detail.developer .data span span";

    private static final String GENRES_SELECTOR = ".product_genre span:not(.label)";

    private static final String RELEASE_DATE_SELECTOR = ".summary_details .release_data .data";

    private static final String SCORE_SELECTOR = ".score_summary .metascore_anchor div:not(.user)";

    private static final String SEASONS_SELECTOR = ".product_seasons a";

    private static final String SUMMARY_SELECTOR = ".product_details .product_summary .data span";

    private static final String TITLE_SELECTOR = "h1.product_title a span";

    private static final String TRAILER_SELECTOR = ".summary_trailer #video_holder_wrapper";

    private static final String USER_SCORE_SELECTOR = ".score_summary .metascore_anchor div.user";

    public MetacriticTVShow() {
        super();
    }

    public MetacriticTVShow(MetacriticPage page) {
        super(page);
        setTitle(page.getFieldAsText(TITLE_SELECTOR));
        setScore(page.getFieldAsText(SCORE_SELECTOR));
        setReleaseDate(page.getFieldAsDate(RELEASE_DATE_SELECTOR));
        setActors(page.getFieldsAsText(ACTORS_SELECTOR));
        setSummary(page.getFieldAsText(SUMMARY_SELECTOR));
        setCreators(page.getFieldsAsText(CREATORS_SELECTOR));
        setGenres(page.getFieldsAsText(GENRES_SELECTOR));
        setTrailer(page.getField(TRAILER_SELECTOR).attr("data-mcvideourl"));
        setUserScore(page.getFieldAsText(USER_SCORE_SELECTOR));
        setSeasons(page.getLastFieldAsInteger(SEASONS_SELECTOR));
    }

    private List<String> actors;

    private List<String> creators;

    private Integer seasons = 1;

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getCreators() {
        return creators;
    }

    public void setCreators(List<String> creators) {
        this.creators = creators;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }
}
