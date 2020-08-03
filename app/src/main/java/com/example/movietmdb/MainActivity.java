package com.example.movietmdb;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietmdb.adapter.MovieAdaptador;
import com.example.movietmdb.api.Interface;
import com.example.movietmdb.model.ModelMovies;
import com.example.movietmdb.model.Peliculas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdaptador movieAdaptador;
    private LinearLayoutManager linearLayoutManager;
    private List<Peliculas.Result> movie;
    TextView txt_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        recyclerView = findViewById( R.id.recycler );
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

//            recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
//            movieAdaptador = new MovieAdaptador(resultList );
//           recyclerView.setHasFixedSize( true );
//            recyclerView.setAdapter( movieAdaptador );

//txt_title = findViewById( R.id.txt_title );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( Constant.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        Interface services = retrofit.create( Interface.class );

        Call<Peliculas> call = services.getMovies( Constant.API_KEY );

        call.enqueue( new Callback<Peliculas>() {
            @Override
            public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {

                     if(!response.isSuccessful()){
                         Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                     }

                      movie = response.body().getResults();
                      movieAdaptador = new MovieAdaptador(movie,MainActivity.this);
                      recyclerView.setAdapter(movieAdaptador);


            }

            @Override
            public void onFailure(Call<Peliculas> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
      // movieAdaptador.notifyDataSetChanged();



    }


}