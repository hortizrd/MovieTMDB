package com.example.movietmdb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movietmdb.R;
import com.example.movietmdb.model.ModelMovies;
import com.example.movietmdb.model.Peliculas;

import java.util.List;

public class MovieAdaptador extends RecyclerView.Adapter<MovieAdaptador.ViewHolder> {
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_titulo, txt_descripcion;
        ImageView imageView;

        Context mcontext;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_titulo = itemView.findViewById(R.id.txt_titulo);
            txt_descripcion = itemView.findViewById(R.id.txt_descripcion);
            imageView = (ImageView) itemView.findViewById(R.id.imgpel);

        }
    }

    List<Peliculas.Result> peliculasList;

    public MovieAdaptador(List<Peliculas.Result> peliculasList, Context context) {
        this.peliculasList = peliculasList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listaitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(mContext)
                .load(peliculasList.get(position).getBackdropPath())
                .into(holder.imageView);

        holder.txt_titulo.setText(peliculasList.get(position).getTitle());
        holder.txt_descripcion.setText(peliculasList.get(position).getOverview());

        ((ViewHolder)holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Has tocado la imagen" + position , Toast.LENGTH_SHORT).show();
            }
        });

        ((ViewHolder)holder).txt_descripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "has tocado la descripcion", Toast.LENGTH_SHORT).show();
            }
        });

        ((ViewHolder)holder).txt_titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "has tocado el titulo", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return peliculasList.size();
    }
}
