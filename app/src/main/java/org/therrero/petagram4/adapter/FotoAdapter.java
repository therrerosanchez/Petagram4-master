package org.therrero.petagram4.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.therrero.petagram4.FotoMascota;
import org.therrero.petagram4.R;

import java.util.ArrayList;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoMascotaViewHolder> {

    ArrayList<FotoMascota> mascotas;
    Activity activity;

    public FotoAdapter(ArrayList<FotoMascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FotoAdapter.FotoMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto_mascota, parent,false);
        return new FotoAdapter.FotoMascotaViewHolder(v);
    }

    //Asocia cada elemento de nuestra vista con cada view
    @Override
    public void onBindViewHolder(@NonNull FotoAdapter.FotoMascotaViewHolder FotoMascotaViewHolder, int position) {
        final FotoMascota mascota = mascotas.get(position);
        FotoMascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        FotoMascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class FotoMascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvLikesCV;

        public FotoMascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.fotoMascota);
            tvLikesCV = (TextView) itemView.findViewById(R.id.Fotolikes);
        }
    }
}
