package org.therrero.petagram4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class RatedActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotasRated;
    private RecyclerView listaDeMascotasRated;
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

        mascotasRated.add(new Mascota("Pepi", R.drawable.mascota1,0));
        mascotasRated.add(new Mascota("Chispas", R.drawable.mascota3,0));
        mascotasRated.add(new Mascota("Toby",R.drawable.mascota4,0));
        mascotasRated.add(new Mascota("Miky",R.drawable.mascota6,0));
        mascotasRated.add(new Mascota("Aris",R.drawable.mascota8,0));

    }

    public void inializarAdaptador(){
        adaptadorRated = new MascotaAdaptador(mascotasRated, this);
        listaDeMascotasRated.setAdapter(adaptadorRated);
    }

    public void onClickBack(View view) {
        onBackPressed();
    }
}
