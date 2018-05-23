package org.therrero.petagram4.fragment;

import org.therrero.petagram4.adapter.MascotaAdaptador;
import org.therrero.petagram4.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
