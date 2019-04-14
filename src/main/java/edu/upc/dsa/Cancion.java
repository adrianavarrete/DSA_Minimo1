package edu.upc.dsa;



public class Cancion {

    private String id;
    private String titulo;
    private String idArtista;
    private double duracion;
    private String album;


    public Cancion(){

    }

    public Cancion(String id, String titulo, String idArtista, double duration, String album){
        this.id = id;
        this.titulo = titulo;
        this.idArtista = idArtista;
        this.duracion = duration;
        this.album = album;

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

    public String getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}


