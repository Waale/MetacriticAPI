package com.sarryromain.metacriticapi.review;

import com.sarryromain.metacriticapi.core.MetacriticPage;
import com.sarryromain.metacriticapi.core.interfaces.IMetacriticAPI;
import com.sarryromain.metacriticapi.review.enums.MetacriticGamePlatform;

public class MetacriticGame extends MetacriticReview {
    public static String URL_BASE = IMetacriticAPI.URL_BASE + "game/";

    public static String URL_SEARCH = IMetacriticAPI.URL_SEARCH + "game/";

    private static final String DEVELOPER_SELECTOR = ".summary_detail.developer .data";

    private static final String GENRES_SELECTOR = ".product_genre span:not(.label)";

    private static final String RATING_SELECTOR = ".summary_detail.product_rating .data";

    private static final String RELEASE_DATE_SELECTOR = ".summary_details .release_data .data";

    private static final String SCORE_SELECTOR = ".score_summary .metascore_anchor div:not(.user)";

    private static final String SUMMARY_SELECTOR = ".product_details .product_summary .data span";

    private static final String TITLE_SELECTOR = "h1.product_title a span";

    private static final String TRAILER_SELECTOR = ".summary_trailer #video_holder_wrapper";

    private static final String USER_SCORE_SELECTOR = ".score_summary .metascore_anchor div.user";

    public MetacriticGame(MetacriticGamePlatform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public MetacriticGame(MetacriticPage page, MetacriticGamePlatform gamePlatform) {
        super(page);
        setGamePlatform(gamePlatform);
        setTitle(page.getFieldAsText(TITLE_SELECTOR));
        setScore(page.getFieldAsText(SCORE_SELECTOR));
        setReleaseDate(page.getFieldAsDate(RELEASE_DATE_SELECTOR));
        setSummary(page.getFieldAsText(SUMMARY_SELECTOR));
        setGenres(page.getFieldsAsText(GENRES_SELECTOR));
        setTrailer(page.getField(TRAILER_SELECTOR).attr("data-mcvideourl"));
        setUserScore(page.getFieldAsText(USER_SCORE_SELECTOR));
        setDeveloper(page.getFieldAsText(DEVELOPER_SELECTOR));
        setRating(page.getFieldAsText(RATING_SELECTOR));
    }

    private String developer;

    private MetacriticGamePlatform gamePlatform;

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public MetacriticGamePlatform getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(MetacriticGamePlatform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }
}
