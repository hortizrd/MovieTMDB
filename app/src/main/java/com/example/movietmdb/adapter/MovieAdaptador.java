package com.example.movietmdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movietmdb.R;
import com.example.movietmdb.model.Peliculas;

import java.util.List;

public class MovieAdaptador  extends RecyclerView.Adapter<MovieAdaptador.ViewHolder> {

    public static class  ViewHolder extends  RecyclerView.ViewHolder{
        TextView txt_titulo,txt_descripcion;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_titulo = itemView.findViewById( R.id.txt_titulo );
            txt_descripcion = itemView.findViewById( R.id.txt_descripcion );


        }
    }
    List<Peliculas.Result> peliculasList;

    public MovieAdaptador(List<Peliculas.Result> peliculasList) {
        this.peliculasList = peliculasList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.listaitem,parent,false );
       ViewHolder viewHolder = new ViewHolder( view );

       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txt_titulo.setText( peliculasList.get( 0 ).getTitle() );
            holder.txt_descripcion.setText( peliculasList.get( 0 ).getOverview() );
    }

    @Override
    public int getItemCount() {
        return peliculasList.size();
    }
}
