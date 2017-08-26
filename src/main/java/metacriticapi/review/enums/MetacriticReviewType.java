package metacriticapi.review.enums;

/**
 * Created by Romain on 26/08/2017.
 */
public enum MetacriticReviewType {
    GAMES ("games"),
    MOVIES ("movies"),
    MUSIC ("music"),
    TV ("tv");

    private String filterOption;

    MetacriticReviewType(String filterOption) {
        this.filterOption = filterOption;
    }

    public String getFilterOption() {
        return filterOption;
    }

    public void setFilterOption(String filterOption) {
        this.filterOption = filterOption;
    }
}
