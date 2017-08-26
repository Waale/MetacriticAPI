package com.sarryromain.metacriticapi.person.service;

import com.sarryromain.metacriticapi.core.MetacriticAPI;
import com.sarryromain.metacriticapi.core.MetacriticPage;
import com.sarryromain.metacriticapi.person.MetacriticPerson;

import java.util.List;

/**
 * Created by Romain on 26/08/2017.
 */
public class MetacriticPersonService {
    private final static String SEARCH_SELECTOR = ".search_results .product_title a";

    private MetacriticAPI api = new MetacriticAPI();

    public MetacriticPerson getByName(String name) {
        return new MetacriticPerson(api.getPageByUrl(MetacriticPerson.URL_BASE + api.parseNameForUrl(name)));
    }

    public List<String> search(String name) {
        MetacriticPage page = api.getPageByUrl(MetacriticPerson.URL_SEARCH + api.parseNameForUrl(name) + MetacriticAPI.URL_SEARCH_END);
        return page.getFieldsAsText(SEARCH_SELECTOR);
    }
}
