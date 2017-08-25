package com.sarryromain.metacriticapi.review;

import com.sarryromain.metacriticapi.core.MetacriticAPI;
import com.sarryromain.metacriticapi.core.MetacriticPage;

import java.util.SortedMap;

/**
 * Created by Romain on 20/08/2017.
 */
public class MetacriticAlbum extends MetacriticReview {
    public static String URL_BASE = MetacriticAPI.URL_BASE + "music/";

    public static String URL_DETAILS_END = "/details";

    public static String URL_SEARCH = MetacriticAPI.URL_SEARCH + "album/";

    private static final String LABEL_SELECTOR = ".summary_detail.product_company .data";

    private static final String GENRES_SELECTOR = ".product_genre span:not(.label)";

    private static final String RELEASE_DATE_SELECTOR = ".summary_detail.release .data";

    private static final String SCORE_SELECTOR = ".score_summary .metascore_anchor div:not(.user)";

    private static final String SUMMARY_SELECTOR = ".product_details .product_summary .data span";

    private static final String TITLE_SELECTOR = ".product_title a span";

    private static final String TRACKS_SELECTOR_NUMBER = ".tracknum";

    private static final String TRACKS_SELECTOR_TITLE = ".tracktitle";

    private static final String USER_SCORE_SELECTOR = ".score_summary .metascore_anchor div.user";

    public MetacriticAlbum() {
        super();
    }

    public MetacriticAlbum(MetacriticPage page, MetacriticPage detailsPage) {
        super(page);
        setDetailsPage(detailsPage);
        setTitle(page.getFieldAsText(TITLE_SELECTOR));
        setScore(page.getFieldAsText(SCORE_SELECTOR));
        setReleaseDate(page.getFieldAsDate(RELEASE_DATE_SELECTOR));
        setSummary(page.getFieldAsText(SUMMARY_SELECTOR));
        setGenres(page.getFieldsAsText(GENRES_SELECTOR));
        setUserScore(page.getFieldAsText(USER_SCORE_SELECTOR));
        setLabel(page.getFieldAsText(LABEL_SELECTOR));
        setTracks(detailsPage.getAlbumTracks(TRACKS_SELECTOR_NUMBER, TRACKS_SELECTOR_TITLE));
    }

    private MetacriticPage detailsPage;

    private String label;

    private SortedMap<String, String> tracks;

    public MetacriticPage getDetailsPage() {
        return detailsPage;
    }

    public void setDetailsPage(MetacriticPage detailsPage) {
        this.detailsPage = detailsPage;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addTrack(String number, String title) {
        tracks.put(number, title);
    }

    public SortedMap<String, String> getTracks() {
        return tracks;
    }

    public void setTracks(SortedMap<String, String> tracks) {
        this.tracks = tracks;
    }
}
