package com.example.movietmdb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movietmdb.api.Interface;
import com.example.movietmdb.model.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://api.themoviedb.org/3/" )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        Interface services = retrofit.create( Interface.class );

        Call<Peliculas> call = services.getMovies( "b2001e6506b91c60a0506048870e670f");

      call.enqueue( new Callback<Peliculas>() {
          @Override
          public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
            List<Peliculas.Result> peliculas = response.body().getResults();


          }

          @Override
          public void onFailure(Call<Peliculas> call, Throwable t) {

          }
      } );
    }
}