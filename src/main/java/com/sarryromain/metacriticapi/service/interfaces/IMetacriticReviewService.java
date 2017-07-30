package com.sarryromain.metacriticapi.service.interfaces;

import com.sarryromain.metacriticapi.review.MetacriticReview;

import java.util.List;

/**
 * Created by Romain on 30/07/2017.
 */
public interface IMetacriticReviewService {
    <T extends MetacriticReview> T getByTitle(String title);

    List<String> search(String title);
}
