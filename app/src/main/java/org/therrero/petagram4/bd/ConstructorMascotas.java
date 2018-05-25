package org.therrero.petagram4.bd;

import android.content.ContentValues;
import android.content.Context;

import org.therrero.petagram4.R;
import org.therrero.petagram4.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas (Context context){
        this.context= context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodosLosMascotas();
    }

    public ArrayList<Mascota> obtenerMejoresMascotas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMejoresMascotas();
    }


    public void insertarTresMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pepi");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota1);

        db.insertarMascota(contentValues);

        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Churri");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota2);

        db.insertarMascota(contentValues);

        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Arial");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota3);

        db.insertarMascota(contentValues);

        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chori");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota4);

        db.insertarMascota(contentValues);

        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Quince");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota5);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        mascota.addLike();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, mascota.getLikes());

        db.insertarLikeMascota(mascota.getId(), mascota.getLikes());
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
