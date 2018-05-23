package org.therrero.petagram4.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.therrero.petagram4.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }


    //Se crea la estructura de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + " ( " +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER " +" ) ";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + " ( " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES + " INTEGER, " +
                " FOREIGN KEY ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " ) " +
                " REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + " ( " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + " ) " +
                " ) ";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLosMascotas (){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES + " ) as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " = " + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

            //  mascotaActual.setLikes();

        }

        db.close();
        return mascotas;
    }

    public void insertarMascota( ContentValues contentValues){
        SQLiteDatabase db =  this.getReadableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues );
        db.close();
    }

    public void insertarLikeMascota (ContentValues contentValues){
        SQLiteDatabase db =  this.getReadableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues );
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES + " ) " +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }
}