package com.sarryromain.metacriticapi.service;

import com.sarryromain.metacriticapi.core.MetacriticAPI;
import com.sarryromain.metacriticapi.core.MetacriticPage;
import com.sarryromain.metacriticapi.core.interfaces.IMetacriticAPI;
import com.sarryromain.metacriticapi.review.MetacriticGame;
import com.sarryromain.metacriticapi.review.enums.MetacriticGamePlatform;

import java.util.List;

/**
 * Created by Romain on 19/08/2017.
 */
public class MetacriticGameService {
    private final static String SEARCH_SELECTOR = ".search_results .product_title a";

    public MetacriticGameService() {

    }

    private MetacriticAPI api = new MetacriticAPI();

    public MetacriticGame getByTitle(String title, MetacriticGamePlatform platform) {
        return new MetacriticGame(api.getPageByUrl(MetacriticGame.URL_BASE + platform.getPlatform() + "/" + api.parseNameForUrl(title)), platform);
    }

    public List<String> search(String title) {
        MetacriticPage page = api.getPageByUrl(MetacriticGame.URL_SEARCH + api.parseNameForUrl(title) + IMetacriticAPI.URL_SEARCH_END);
        return page.getFieldsAsText(SEARCH_SELECTOR);
    }
}
