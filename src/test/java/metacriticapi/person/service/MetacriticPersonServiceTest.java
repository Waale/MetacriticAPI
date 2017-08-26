package metacriticapi.person.service;

import metacriticapi.person.MetacriticParticipation;
import metacriticapi.person.MetacriticPerson;
import metacriticapi.review.MetacriticReview;
import metacriticapi.review.enums.MetacriticReviewType;
import org.junit.Test;

import java.util.List;

/**
 * Created by Romain on 26/08/2017.
 */
public class MetacriticPersonServiceTest {
    @Test
    public void personTest() {
        MetacriticPersonService service = new MetacriticPersonService();
        MetacriticPerson person = service.getByName("Bryan Cranston");
        System.out.println("PERSON TEST");
        System.out.println("Name : " + person.getName());
        System.out.println("Biography : " + person.getBiography());
        System.out.print("Review Types :");
        for (MetacriticReviewType reviewType : person.getReviewTypes()) {
            System.out.print(" " + reviewType);
        }
        System.out.println();
        System.out.println("Participations :");
        for (MetacriticParticipation participation : person.getParticipations()) {
            MetacriticReview review = participation.getReview();
            System.out.println("    Title : " + review.getTitle());
            System.out.println("        Review Type : " + participation.getReviewType().getFilterOption());
            System.out.println("        Credit : " + participation.getCredit());
            System.out.println("        Release Date : " + review.getReleaseDate());
            System.out.println("        Score : " + review.getScore());
            System.out.println("        User Score : " + review.getUserScore());
        }
    }

    @Test
    public void personSearch() {
        MetacriticPersonService service = new MetacriticPersonService();
        List<String> persons = service.search("Emilia");
        for (String person : persons) {
            System.out.println(person);
        }
    }
}
