package org.therrero.petagram4;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.therrero.petagram4.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de nuestra vista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.imgHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.addLike();
                Toast.makeText(activity, "Diste LIKE a " + mascota.getNombre() + ". Lleva " + mascota.getLikes() + " likes.", Toast.LENGTH_SHORT).show();
            }
        });


/*        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,mascota.getNombre(), Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageView imgHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.foto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.nombre);
            tvLikesCV = (TextView) itemView.findViewById(R.id.likes);
            imgHueso =(ImageView) itemView.findViewById(R.id.hueso);
        }
    }
}

