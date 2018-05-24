package org.therrero.petagram4.bd;

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS = "mascota";
    public static final String TABLE_MASCOTAS_ID = "id";
    public static final String TABLE_MASCOTAS_NOMBRE = "nombre";
    public static final String TABLE_MASCOTAS_LIKES = "likes";
    public static final String TABLE_MASCOTAS_FOTO = "foto";


    public static final String TABLE_LIKES_MASCOTA = "mascota_likes" ;
    public static final String TABLE_LIKES_MASCOTA_ID = "id" ;
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_MASCOTA_ID_NUMERO_LIKES = "numero_likes";
}
