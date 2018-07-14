package com.deltax.movies.models;


import com.deltax.movies.entity.Actors;

import java.util.List;

public class AddMovieRequest {
    private String name;
    private String yearOfRelease;
    private String plot;
    private String posterUrl;
    private List<Integer> actorsId;
    private String producerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public List<Integer> getActorsId() {
        return actorsId;
    }

    public void setActorsId(List<Integer> actorsId) {
        this.actorsId = actorsId;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }
}
