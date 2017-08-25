package com.sarryromain.metacriticapi.review;

import com.sarryromain.metacriticapi.core.MetacriticPage;

import java.util.Date;
import java.util.List;

/**
 * Created by Romain on 29/07/2017.
 */
public abstract class MetacriticReview {
    public MetacriticReview() {

    }

    public MetacriticReview(MetacriticPage page) {
        setPage(page);
    }

    MetacriticPage page;

    private List<String> genres;

    private String rating;

    private Date releaseDate;

    private String score;

    private String summary;

    private String title;

    private String trailer;

    private String userScore;

    public MetacriticPage getPage() {
        return page;
    }

    public void setPage(MetacriticPage page) {
        this.page = page;
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }
}
