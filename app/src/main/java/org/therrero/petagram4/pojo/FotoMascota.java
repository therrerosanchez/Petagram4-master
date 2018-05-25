package org.therrero.petagram4.pojo;

public class FotoMascota {
    private int foto;
    private int likes;

    public FotoMascota( int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
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
