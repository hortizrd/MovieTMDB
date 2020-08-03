package com.example.movietmdb.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class Movies {

    @Expose
    @SerializedName("results")
    private List<Results> results;
    @Expose
    @SerializedName("total_pages")
    private int total_pages;
    @Expose
    @SerializedName("total_results")
    private int total_results;
    @Expose
    @SerializedName("page")
    private int page;

    public List<Results> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getPage() {
        return page;
    }

    public static class Results {
        @Expose
        @SerializedName("release_date")
        private String release_date;
        @Expose
        @SerializedName("overview")
        private String overview;
        @Expose
        @SerializedName("vote_average")
        private double vote_average;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("genre_ids")
        private List<Movies> genre_ids;
        @Expose
        @SerializedName("original_title")
        private String original_title;
        @Expose
        @SerializedName("original_language")
        private String original_language;
        @Expose
        @SerializedName("backdrop_path")
        private String backdrop_path;
        @Expose
        @SerializedName("adult")
        private boolean adult;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("poster_path")
        private String poster_path;
        @Expose
        @SerializedName("video")
        private boolean video;
        @Expose
        @SerializedName("vote_count")
        private int vote_count;
        @Expose
        @SerializedName("popularity")
        private double popularity;

        public String getRelease_date() {
            return release_date;
        }

        public String getOverview() {
            return overview;
        }

        public double getVote_average() {
            return vote_average;
        }

        public String getTitle() {
            return title;
        }

        public List<Movies> getGenre_ids() {
            return genre_ids;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public boolean getAdult() {
            return adult;
        }

        public int getId() {
            return id;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public boolean getVideo() {
            return video;
        }

        public int getVote_count() {
            return vote_count;
        }

        public double getPopularity() {
            return popularity;
        }
    }
}
