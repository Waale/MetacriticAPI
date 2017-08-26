package metacriticapi.person;

import metacriticapi.review.MetacriticReview;
import metacriticapi.review.enums.MetacriticReviewType;

/**
 * Created by Romain on 26/08/2017.
 */
public class MetacriticParticipation {
    public static String PARTICIPATION_SELECTOR = ".person_credits tbody tr";

    public MetacriticParticipation() {

    }

    public MetacriticParticipation(String credit, MetacriticReview review, MetacriticReviewType reviewType) {
        this.credit = credit;
        this.review = review;
        this.reviewType = reviewType;
    }

    private String credit;

    private MetacriticReview review;

    private MetacriticReviewType reviewType;

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public MetacriticReview getReview() {
        return review;
    }

    public void setReview(MetacriticReview review) {
        this.review = review;
    }

    public MetacriticReviewType getReviewType() {
        return reviewType;
    }

    public void setReviewType(MetacriticReviewType reviewType) {
        this.reviewType = reviewType;
    }
}
