package metacriticapi.person;

import metacriticapi.core.MetacriticAPI;
import metacriticapi.core.MetacriticPage;
import metacriticapi.person.service.MetacriticParticipationService;
import metacriticapi.review.enums.MetacriticReviewType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 26/08/2017.
 */
public class MetacriticPerson {
    private MetacriticParticipationService service = new MetacriticParticipationService();

    public static String URL_BASE = MetacriticAPI.URL_BASE + "person/";

    public static String URL_SEARCH = MetacriticAPI.URL_SEARCH + "person/";

    private static final String BIOGRAPHY_SELECTOR = ".bio .blurb_expanded";

    private static final String NAME_SELECTOR = ".person_title";

    private static final String CURRENT_REVIEW_TYPE_SELECTOR = ".person_credits_module .head li .active";

    private static final String REVIEW_TYPES_SELECTOR = ".person_credits_module .head li span:not(.active)";

    public MetacriticPerson() {

    }

    public MetacriticPerson(MetacriticPage page) {
        setPage(page);
        setName(page.getFieldAsText(NAME_SELECTOR));
        setBiography(page.getFieldAsText(BIOGRAPHY_SELECTOR));
        setCurrentReviewType(MetacriticReviewType.valueOf(page.getFieldAsText(CURRENT_REVIEW_TYPE_SELECTOR).toUpperCase()));
        setParticipations(service.getByPage(page, currentReviewType));
        setReviewTypes(new ArrayList<MetacriticReviewType>());
        for (String reviewType : page.getFieldsAsText(REVIEW_TYPES_SELECTOR)) {
            addReviewType(MetacriticReviewType.valueOf(reviewType.toUpperCase()));
            if (MetacriticReviewType.valueOf(reviewType.toUpperCase()) != currentReviewType) {
                addParticipations(service.getByNameAndReviewType(name, MetacriticReviewType.valueOf(reviewType.toUpperCase())));
            }
        }
    }

    private String biography;

    private String name;

    private MetacriticPage page;

    private List<MetacriticParticipation> participations;

    private MetacriticReviewType currentReviewType;

    private List<MetacriticReviewType> reviewTypes;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MetacriticPage getPage() {
        return page;
    }

    public void setPage(MetacriticPage page) {
        this.page = page;
    }

    public void addParticipation(MetacriticParticipation participation) {
        participations.add(participation);
    }

    public void addParticipations(List<MetacriticParticipation> participations) {
        for (MetacriticParticipation participation : participations) {
            this.participations.add(participation);
        }
    }

    public List<MetacriticParticipation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<MetacriticParticipation> participations) {
        this.participations = participations;
    }

    public MetacriticReviewType getCurrentReviewType() {
        return currentReviewType;
    }

    public void setCurrentReviewType(MetacriticReviewType currentReviewType) {
        this.currentReviewType = currentReviewType;
    }

    public void addReviewType(MetacriticReviewType reviewType) {
        reviewTypes.add(reviewType);
    }

    public List<MetacriticReviewType> getReviewTypes() {
        return reviewTypes;
    }

    public void setReviewTypes(List<MetacriticReviewType> reviewTypes) {
        this.reviewTypes = reviewTypes;
    }

    public Boolean hasAlbums() {
        return reviewTypes.contains(MetacriticReviewType.MUSIC);
    }

    public Boolean hasGames() {
        return reviewTypes.contains(MetacriticReviewType.GAMES);
    }

    public Boolean hasMovies() {
        return reviewTypes.contains(MetacriticReviewType.MOVIES);
    }

    public Boolean hasTVShows() {
        return reviewTypes.contains(MetacriticReviewType.TV);
    }
}
