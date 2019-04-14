package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class User {

    private final static Logger log = Logger.getLogger(User.class.getName());
    private String id;
    private String nombre;
    private String apellido;
    private List<Playlist> playlists;

    public User(){
        this.playlists = new LinkedList<>();
    }

    public User(String id, String nombre, String apellido){

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.playlists = new LinkedList<>();

    }

    public Playlist getPlaylistById(String idPlaylist) throws PlaylistNotFoundException {

        return this.playlists.get(getPosListaById(idPlaylist));

    }

    public int getPosListaById(String id) throws PlaylistNotFoundException {

        int pos = -1;

        for(Playlist p: this.playlists)
        {
            int i = 0;

            if(p.getId() == id){
                pos = i;
                break;

            }
            else{

                i++;

            }
        }

        if(pos != -1){
            return pos;
        }
        else{

            log.fatal("Playlist " + id + " no encontrado");
            throw new PlaylistNotFoundException();

        }



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

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void añadirPlaylist(Playlist p){
        this.playlists.add(p);
    }
}
