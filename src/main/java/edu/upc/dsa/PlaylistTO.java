package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class PlaylistTO {

    private String id;
    private String nombre;
    private String idUser;


    public PlaylistTO(String id, String nombre, String idUser) {
        this.id = id;
        this.nombre = nombre;
        this.idUser = idUser;

    }

    public PlaylistTO(){

    }

    public String getNombre() {
        return nombre;
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



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

