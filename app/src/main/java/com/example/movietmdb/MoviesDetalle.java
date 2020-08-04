package com.example.movietmdb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MoviesDetalle extends AppCompatActivity {

    TextView txt_title,txt_descripcion;
    ImageView app_bar_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_movies_detalle );
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // initColapsingToolbar();
        app_bar_image = findViewById(R.id.app_bar_image);
        txt_title = findViewById(R.id.txt_title);
        txt_descripcion = findViewById(R.id.txt_descripcion);

//        Intent intent = getIntent();
//        if (intent.hasExtra("original_title")){
//            String thumbnail = getIntent().getExtras().getString("poster_path");
//            String movieName = getIntent().getExtras().getString("original_title");
//            String synopsis = getIntent().getExtras().getString("overview");
//
//            Glide.with(this)
//                    .load(thumbnail)
//                    .placeholder(R.drawable.ic_launcher_foreground)
//                    .into(app_bar_image);
//
//            txt_title.setText(movieName);
//            txt_descripcion.setText(synopsis);
//
//
//
//        }else{
//            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
//
//        }

//        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
//        collapsingToolbarLayout.setTitleEnabled(true);
               // getSupportActionBar().hide();
      String thumbnail = getIntent().getExtras().getString("poster_path");
                  String movieName = getIntent().getExtras().getString("title");
                   String synopsis = getIntent().getExtras().getString("overview");

        Glide.with(this)
                .load(thumbnail)
                .into(app_bar_image);

           txt_title.setText(movieName);
         txt_descripcion.setText(synopsis);



    }



    private  void initColapsingToolbar(){
        final CollapsingToolbarLayout collapsingToolbarLayout =(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.toolbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
              if(scrollRange == -1){
                  scrollRange = appBarLayout.getTotalScrollRange();

              }
              if(scrollRange + verticalOffset == 0){
                  collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                  isShow = true;
                  }else if(isShow){
                  collapsingToolbarLayout.setTitle("");
                  isShow =false;

              }
            }
        });
    }
}