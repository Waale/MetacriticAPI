package com.sarryromain.metacriticapi.service;

import com.sarryromain.metacriticapi.core.MetacriticAPI;
import com.sarryromain.metacriticapi.review.MetacriticMovie;
import com.sarryromain.metacriticapi.service.interfaces.IMetacriticReviewService;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticMovieService implements IMetacriticReviewService {
    public MetacriticMovieService() {

    }

    public MetacriticMovie getByTitle(String title) {
        MetacriticAPI api = new MetacriticAPI();
        return new MetacriticMovie(api.getPageByUrl(MetacriticMovie.URL_BASE + api.parseNameForUrl(title)));
    }
}
