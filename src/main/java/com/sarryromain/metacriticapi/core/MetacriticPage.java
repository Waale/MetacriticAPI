package com.sarryromain.metacriticapi.core;

import com.sarryromain.metacriticapi.person.MetacriticParticipation;
import com.sarryromain.metacriticapi.review.*;
import com.sarryromain.metacriticapi.review.enums.MetacriticReviewType;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Romain on 29/07/2017.
 */
public class MetacriticPage {
    public MetacriticPage(Document htmlDom) {
        this.htmlDom = htmlDom;
    }

    Document htmlDom;

    SimpleDateFormat formatter = new SimpleDateFormat("MMMMM d, yyyy", Locale.US);

    public Document getHtmlDom() {
        return htmlDom;
    }

    public void setHtmlDom(Document htmlDom) {
        this.htmlDom = htmlDom;
    }

    public Element getField(String selector) {
        return getHtmlDom().select(selector).first();
    }

    public Element getLastField(String selector) {
        return getHtmlDom().select(selector).last();
    }

    public Date getFieldAsDate(String selector) {
        try {
            return formatter.parse(getFieldAsText(selector));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer getFieldAsInteger(String selector) {
        try {
            return Integer.valueOf(getFieldAsText(selector));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer getLastFieldAsInteger(String selector) {
        try {
            return Integer.valueOf(getLastFieldAsText(selector));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getFieldAsText(String selector) {
        return getField(selector).text();
    }

    public String getLastFieldAsText(String selector) {
        return getLastField(selector).text();
    }

    public List<String> getFieldsAsText(String selector) {
        return getHtmlDom().select(selector).eachText();
    }

    public SortedMap<String, String> getAlbumTracks(String numberSelector, String titleSelector) {
        SortedMap<String, String> tracks = new TreeMap<String, String>();
        String number;
        String title;

        List<String> numbers = getFieldsAsText(numberSelector);
        List<String> titles = getFieldsAsText(titleSelector);

        for (int i = 0; i < numbers.size(); i++ ) {
            number = numbers.get(i);
            title = titles.get(i);

            if (number != null && number != "" && title != null && title != "") {
                tracks.put(number, title);
            }
        }

        return tracks;
    }

    public List<MetacriticParticipation> getParticipations(String selector, MetacriticReviewType reviewType) {
        List<MetacriticParticipation> participations = new ArrayList<MetacriticParticipation>();
        Elements elements = getHtmlDom().select(selector);
        for (Element element : elements) {
            MetacriticReview review = null;

            String credit = element.select(".role").first().text();
            Date date = null;
            try {
                date = formatter.parse(element.select(".year").first().text());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            String score = element.select(".metascore_w").first().text();
            String title = element.select(".title a").first().text();
            String userScore = element.select(".score .data").first().text();

            switch (reviewType) {
                case GAMES:
                    review = new MetacriticGame(date, score, title, userScore);
                    break;
                case MOVIES:
                    review = new MetacriticMovie(date, score, title, userScore);
                    break;
                case MUSIC:
                    review = new MetacriticAlbum(date, score, title, userScore);
                    break;
                case TV:
                    review = new MetacriticTVShow(date, score, title, userScore);
                    break;
                default:
                    break;
            }

            if (review != null) {
                participations.add(new MetacriticParticipation(credit, review, reviewType));
            }
        }

        return participations;
    }
}
