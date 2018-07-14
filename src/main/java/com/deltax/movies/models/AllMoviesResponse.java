package com.deltax.movies.models;

import java.util.ArrayList;
import java.util.List;

public class AllMoviesResponse {
    private ArrayList<MoviesResponse> moviesResponseList;

    public ArrayList<MoviesResponse> getMoviesResponseList() {
        return moviesResponseList;
    }

    public void setMoviesResponseList(ArrayList<MoviesResponse> moviesResponseList) {
        this.moviesResponseList = moviesResponseList;
    }
}
