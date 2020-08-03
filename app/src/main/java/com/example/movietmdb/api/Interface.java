package com.example.movietmdb.api;

import com.example.movietmdb.model.Peliculas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface {

    @GET("movie/popular")
    Call<Peliculas>  getMovies(@Query( "api_key" )String api_key);
}
