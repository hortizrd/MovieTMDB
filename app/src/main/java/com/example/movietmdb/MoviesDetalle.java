package com.example.movietmdb;


import android.os.Bundle;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class MoviesDetalle extends AppCompatActivity {

    TextView txt_title, txt_descripcion, textview_progress;
    ImageView app_bar_image;
    ProgressBar progressBar;
    int progr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detalle);




        Toolbar toolbar = findViewById(R.id.toolbar);

        app_bar_image = findViewById(R.id.app_bar_image);
        txt_title = findViewById(R.id.txt_title);
        txt_descripcion = findViewById(R.id.txt_descripcion);
        textview_progress = findViewById(R.id.textview_progress);

        String thumbnail = getIntent().getExtras().getString("poster_path");
        String movieName = getIntent().getExtras().getString("title");
        String synopsis = getIntent().getExtras().getString("overview");
        String average = getIntent().getExtras().get("average").toString();

        Glide.with(this)
                .load(thumbnail)
                .into(app_bar_image);

        txt_title.setText(movieName);
        txt_descripcion.setText(synopsis);






    }


    private void updateProgressbar() {

        progressBar.setProgress(82);

        textview_progress.setText("82");

    }


}