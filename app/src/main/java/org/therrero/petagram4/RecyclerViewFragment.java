package org.therrero.petagram4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.therrero.petagram4.adapter.MascotaAdaptador;
import org.therrero.petagram4.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeMascotas;
    public MascotaAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaDeMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaDeMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inializarAdaptador();
        return v;
    }

    public void inializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaDeMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas= new ArrayList<Mascota>();

        mascotas.add(new Mascota("Pepi", R.drawable.mascota1,0));
        mascotas.add(new Mascota("Chewi", R.drawable.mascota2,0));
        mascotas.add(new Mascota("Chispas", R.drawable.mascota3,0));
        mascotas.add(new Mascota("Toby",R.drawable.mascota4,0));
        mascotas.add(new Mascota("Kiki",R.drawable.mascota5,0));
        mascotas.add(new Mascota("Miky",R.drawable.mascota6,0));
        mascotas.add(new Mascota("Trump",R.drawable.mascota7,0));
        mascotas.add(new Mascota("Aris",R.drawable.mascota8,0));

    }
}
