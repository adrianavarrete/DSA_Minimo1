package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class Playlist {

    private String id;
    private String nombre;
    private String idUser;
    private List<Cancion> canciones;

    public Playlist(String id,String nombre, String idUser) {
        this.id = id;
        this.nombre = nombre;
        this.idUser = idUser;
        this.canciones = new LinkedList<>();
    }

    public Playlist(){

    }

    public String getNombre() {
        return nombre;
    }

    public void addCancion(Cancion c){

        this.canciones.add(c);



    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

