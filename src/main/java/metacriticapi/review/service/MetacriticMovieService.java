package metacriticapi.review.service;

import metacriticapi.core.MetacriticAPI;
import metacriticapi.core.MetacriticPage;
import metacriticapi.review.MetacriticMovie;

import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticMovieService {
    private final static String SEARCH_SELECTOR = ".search_results .product_title a";

    public MetacriticMovieService() {

    }

    private MetacriticAPI api = new MetacriticAPI();

    public MetacriticMovie getByTitle(String title) {
        return new MetacriticMovie(api.getPageByUrl(MetacriticMovie.URL_BASE + api.parseNameForUrl(title)));
    }

    public List<String> search(String title) {
        MetacriticPage page = api.getPageByUrl(MetacriticMovie.URL_SEARCH + api.parseNameForUrl(title) + MetacriticAPI.URL_SEARCH_END);
        return page.getFieldsAsText(SEARCH_SELECTOR);
    }
}
