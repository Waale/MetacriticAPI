package com.sarryromain.metacriticapi.service.interfaces;

import com.sarryromain.metacriticapi.review.MetacriticReview;

/**
 * Created by Romain on 30/07/2017.
 */
public interface IMetacriticReviewService {
    public <T extends MetacriticReview> T getByTitle(String title);
}
