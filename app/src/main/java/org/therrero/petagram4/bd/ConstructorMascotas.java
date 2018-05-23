package org.therrero.petagram4.bd;

import android.content.ContentValues;
import android.content.Context;

import org.therrero.petagram4.R;
import org.therrero.petagram4.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context context;

    public static final int LIKE = 1;
    public ConstructorMascotas (Context context){
        this.context= context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodosLosMascotas();
    }

    public void insertarTresMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pepi");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota1);

        db.insertarMascota(contentValues);

        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Hulk");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota2);

        db.insertarMascota(contentValues);

        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Black Widow");
        contentValues.put(  ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.mascota3);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES, LIKE);

        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}