package com.sarryromain.metacriticapi.service;

import com.sarryromain.metacriticapi.core.MetacriticAPI;
import com.sarryromain.metacriticapi.core.MetacriticPage;
import com.sarryromain.metacriticapi.review.MetacriticTVShow;

import java.util.List;

/**
 * Created by Romain on 19/08/2017.
 */
public class MetacriticTVShowService {
    private final static String SEARCH_SELECTOR = ".search_results .product_title a";

    public MetacriticTVShowService() {

    }

    private MetacriticAPI api = new MetacriticAPI();

    public MetacriticTVShow getByTitle(String title) {
        return new MetacriticTVShow(api.getPageByUrl(MetacriticTVShow.URL_BASE + api.parseNameForUrl(title)));
    }

    public List<String> search(String title) {
        MetacriticPage page = api.getPageByUrl(MetacriticTVShow.URL_SEARCH + api.parseNameForUrl(title) + MetacriticAPI.URL_SEARCH_END);
        return page.getFieldsAsText(SEARCH_SELECTOR);
    }
}
