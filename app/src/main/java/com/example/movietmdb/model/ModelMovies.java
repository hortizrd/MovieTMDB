package com.example.movietmdb.model;

public class ModelMovies {
    private String title;
    private String overview;


    public ModelMovies(String title, String overview) {
        this.title = title;
        this.overview = overview;

    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

//    public String getBackdropPath() {
//        return "https://image.tmdb.org/t/p/w500"+backdropPath;
//    }
}
