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
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " INTEGER " +" ) ";

        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMejoresMascotas (){
        ArrayList<Mascota> mascotas = new ArrayList<>();


        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " DESC LIMIT 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();
        registros.close();
        return mascotas;
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
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();
        registros.close();
        return mascotas;
    }

    public void insertarMascota( ContentValues contentValues){
        SQLiteDatabase db =  this.getReadableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues );
        db.close();
    }

    public void insertarLikeMascota (int id, int likes){
        SQLiteDatabase db =  this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        String where = "id=?";
        String[] whereArgs = new String[] {String.valueOf(id)};

       // contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, id);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, likes);
        db.update(ConstantesBaseDatos.TABLE_MASCOTAS, contentValues, where, whereArgs );
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " " +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + " = " + mascota.getId();

        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        registros.close();
        return likes;
    }
}
