package org.therrero.petagram4.pojo;

import java.util.ArrayList;

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public Mascota(String nombre, int foto, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public Mascota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int idMascota) {
        this.id = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void addLike() {
        this.likes = this.likes+1;
    }

}
