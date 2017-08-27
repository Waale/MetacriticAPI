package metacriticapi.person.service;

import metacriticapi.person.MetacriticParticipation;
import metacriticapi.person.MetacriticPerson;
import metacriticapi.review.MetacriticReview;
import metacriticapi.review.enums.MetacriticReviewType;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

/**
 * Created by Romain on 26/08/2017.
 */
public class MetacriticPersonServiceTest {
    @Test
    public void personTest() {
        MetacriticPersonService service = new MetacriticPersonService();
        MetacriticPerson person = service.getByName("Bryan Cranston");

        assertNotNull(person);
        assertNotNull(person.getName());
        assertNotNull(person.getBiography());
        assertNotNull(person.getReviewTypes());

        assertNotNull(person.getParticipations());
        assertFalse(person.getParticipations().isEmpty());
        for (MetacriticParticipation participation : person.getParticipations()) {
            assertNotNull(participation.getReviewType());
            assertNotNull(participation.getCredit());

            MetacriticReview review = participation.getReview();
            assertNotNull(review);
            assertNotNull(review.getTitle());
            assertNotNull(review.getReleaseDate());
            assertNotNull(review.getScore());
            assertNotNull(review.getUserScore());
        }

        /*System.out.println("PERSON TEST");
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
        }*/
    }

    @Test
    public void personSearchTest() {
        MetacriticPersonService service = new MetacriticPersonService();
        List<String> persons = service.search("Emilia");

        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        assertTrue(persons.contains("Emilia Clarke"));

/*        for (String person : persons) {
            System.out.println(person);
        }*/
    }
}
