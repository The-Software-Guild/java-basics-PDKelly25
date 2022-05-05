package com.m3.c216.assessment2.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DVD {
    private String title, mpaa, director, studio, rating;
    private Double review;
    private Date release_date;
    //private String[] mpaa = new String[]{"G", "PG", "PG-13", "R", "NC-17"};
    //private double rating; //standard rating and any comments
    //private Map dvd_collecion = new HashMap();

    public DVD(String title, Date release_date, String mpaa, String director, String studio, String rating, Double review){
        this.title=title;
        this.release_date = release_date;
        this.mpaa = mpaa;
        this.director = director;
        this.studio = studio;
        this.rating = rating;
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Double getReview() {
        return review;
    }

    public void setReview(Double review) {
        this.review = review;
    }
}
