package edu.upc.dsa;



public class Cancion {

    private String id;
    private String titulo;
    private String artista;
    private double duracion;


    public Cancion(){

    }

    public Cancion(String id, String titulo, String artista, double duration){
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duration;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}


