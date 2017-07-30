package com.sarryromain.metacriticapi.review.interfaces;

import java.util.Date;
import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public interface IMetacriticReview {
    List<String> getGenres();

    void setGenres(List<String> newGenres);

    Date getReleaseDate();

    void setReleaseDate(Date newReleaseDate);

    String getScore();

    void setScore(String newScore);

    String getSummary();

    void setSummary(String newSummary);

    String getTitle();

    void setTitle(String newTitle);

    String getTrailer();

    void setTrailer(String newTrailer);

    String getUserScore();

    void setUserScore(String newUserScore);
}
