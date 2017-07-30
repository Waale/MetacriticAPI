package com.sarryromain.metacriticapi.review;

import com.sarryromain.metacriticapi.core.MetacriticPage;
import com.sarryromain.metacriticapi.review.interfaces.IMetacriticReview;

import java.util.Date;
import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public abstract class MetacriticReview implements IMetacriticReview {
    public MetacriticReview() {

    }

    public MetacriticReview(MetacriticPage page) {
        setPage(page);
    }

    MetacriticPage page;

    public MetacriticPage getPage() {
        return page;
    }

    public void setPage(MetacriticPage page) {
        this.page = page;
    }
}
