package org.therrero.petagram4.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.therrero.petagram4.R;
import org.therrero.petagram4.adapter.FotoAdapter;
import org.therrero.petagram4.pojo.FotoMascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    ArrayList<FotoMascota> fotosmascotas;
    private RecyclerView listaDeFotosDeMascotas;
    public FotoAdapter adaptador;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaDeFotosDeMascotas = (RecyclerView) v.findViewById(R.id.rvFotoMascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        listaDeFotosDeMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inializarAdaptador();
        return v;
    }
    public void inializarAdaptador(){
        adaptador = new FotoAdapter(fotosmascotas, getActivity());
        listaDeFotosDeMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        fotosmascotas= new ArrayList<FotoMascota>();

        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,5));
        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,4));
        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,8));
        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,13));
        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,1));
        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,5));
        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,0));
        fotosmascotas.add(new FotoMascota(R.drawable.mascota1,9));

    }
}
