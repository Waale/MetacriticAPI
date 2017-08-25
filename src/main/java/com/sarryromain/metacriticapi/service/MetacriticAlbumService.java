package com.sarryromain.metacriticapi.service;

import com.sarryromain.metacriticapi.core.MetacriticAPI;
import com.sarryromain.metacriticapi.core.MetacriticPage;
import com.sarryromain.metacriticapi.review.MetacriticAlbum;

import java.util.List;

/**
 * Created by Romain on 20/08/2017.
 */
public class MetacriticAlbumService {
    private final static String SEARCH_SELECTOR = ".search_results .product_title a";

    public MetacriticAlbumService() {

    }

    private MetacriticAPI api = new MetacriticAPI();

    public MetacriticAlbum getByTitleAndAuthor(String title, String author) {
        return new MetacriticAlbum(api.getPageByUrl(MetacriticAlbum.URL_BASE + api.parseNameForUrl(title) + "/" + author),
                api.getPageByUrl(MetacriticAlbum.URL_BASE + api.parseNameForUrl(title) + "/" + author + MetacriticAlbum.URL_DETAILS_END));
    }

    public List<String> search(String title) {
        MetacriticPage page = api.getPageByUrl(MetacriticAlbum.URL_SEARCH + api.parseNameForUrl(title) + MetacriticAPI.URL_SEARCH_END);
        return page.getFieldsAsText(SEARCH_SELECTOR);
    }
}
