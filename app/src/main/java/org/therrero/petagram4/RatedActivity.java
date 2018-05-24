package org.therrero.petagram4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.therrero.petagram4.adapter.MascotaAdaptador;
import org.therrero.petagram4.bd.ConstructorMascotas;
import org.therrero.petagram4.pojo.Mascota;

import java.util.ArrayList;

public class RatedActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotasRated;
    private RecyclerView listaDeMascotasRated;
    private ConstructorMascotas constructorMascotas;
    public MascotaAdaptador adaptadorRated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rated);

        android.support.v7.widget.Toolbar miActionBar2 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(miActionBar2);

        listaDeMascotasRated = (RecyclerView) findViewById(R.id.rvMascotasRated);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaDeMascotasRated.setLayoutManager(llm);
        inicializarListaMascotas();
        inializarAdaptador();

    }
    public void inicializarListaMascotas(){
        mascotasRated= new ArrayList<Mascota>();
        constructorMascotas = new ConstructorMascotas(this);
        mascotasRated = constructorMascotas.obtenerMejoresMascotas();


    }

    public void inializarAdaptador(){
        adaptadorRated = new MascotaAdaptador(mascotasRated, this);
        listaDeMascotasRated.setAdapter(adaptadorRated);
    }

    public void onClickBack(View view) {
        onBackPressed();
    }
}
