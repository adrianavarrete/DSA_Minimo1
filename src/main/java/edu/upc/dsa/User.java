package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class User {

    private String id;
    private String nombre;
    private String apellido;
    private List<Cancion> playlists;

    public User(){
        this.playlists = new LinkedList<>();
    }

    public User(String id, String nombre, String apellido){

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.playlists = new LinkedList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Cancion> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Cancion> playlists) {
        this.playlists = playlists;
    }

    public void añadirPlaylist(Cancion p){
        this.playlists.add(p);
    }
}
