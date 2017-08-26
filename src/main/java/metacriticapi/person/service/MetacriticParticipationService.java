package metacriticapi.person.service;

import metacriticapi.core.MetacriticAPI;
import metacriticapi.core.MetacriticPage;
import metacriticapi.person.MetacriticParticipation;
import metacriticapi.person.MetacriticPerson;
import metacriticapi.review.enums.MetacriticReviewType;

import java.util.List;

/**
 * Created by Romain on 26/08/2017.
 */
public class MetacriticParticipationService {
    private MetacriticAPI api = new MetacriticAPI();

    public List<MetacriticParticipation> getByNameAndReviewType(String name, MetacriticReviewType reviewType) {
        return getByPage(api.getPageByUrl(MetacriticPerson.URL_BASE + api.parseNameForUrl(name) + "?filter-options=" +
                reviewType.getFilterOption() + "&sort_options=date&num_items=100"), reviewType);
    }

    public List<MetacriticParticipation> getByPage(MetacriticPage page, MetacriticReviewType reviewType) {
        return page.getParticipations(MetacriticParticipation.PARTICIPATION_SELECTOR, reviewType);
    }
}
