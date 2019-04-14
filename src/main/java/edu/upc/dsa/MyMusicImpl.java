package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyMusicImpl implements MyMusic {

    private final static Logger log = Logger.getLogger(MyMusicImpl.class.getName());

    private static MyMusicImpl instance;
    private static HashMap<String, User> users;
    private static List<Playlist> playlists;
    private static List<Artista> artistas;


    private MyMusicImpl() {

        this.users = new HashMap<>();
        this.artistas = new LinkedList<>();


    }


    public static MyMusic getInstance() {
        if (instance == null) instance = new MyMusicImpl();
        return instance;
    }


    @Override
    public void addArtista(Artista a) {

        log.info("Se va a añadir un artista al sistema");
        this.artistas.add(a);
        log.info("Se ha añadido el artista " + a.getNombre() + " " + a.getApellido() + " en el sistema");

    }

    @Override
    public List<Artista> dameListaArtistas() {
        log.info("Se esta solicitando el listado de artistas en el sistema");
        return this.artistas;

    }

    @Override
    public void crearPlaylist(Playlist p) {
        log.info("Se va a crear una playlist");

        this.users.get(p.getIdUser()).añadirPlaylist(p);
        log.info("Se ha añadido la playlist '" + p.getNombre() + "' en el usuario con id " + p.getIdUser());


    }

    @Override
    public void addCancionPlaylist(String idPlaylist, String idUser, Cancion c) throws PlaylistNotFoundException, ArtistaNotFoundException {
        log.info("Se va a añadir una canción en una playlist");

        User u = this.users.get(idUser);
        Playlist p = u.getPlaylistById(idPlaylist);

        if (checkArtista(c.getIdArtista()) != false){

            p.addCancion(c);

        }else{
            log.error("Artista no encontrado en el sistema");
            throw new ArtistaNotFoundException();

        }

        log.info("Se ha añadido una canción en la playlist " + p.getId() + " del user " + u.getId());

    }

    @Override
    public List<Cancion> dameListaPlaylistUser(String idUser, String idPlaylist) throws PlaylistNotFoundException {

        log.info("Se soliicta el listado de canciones de una playlist '" + idPlaylist + "' del usuario '" +idUser+"'");
        User u = this.users.get(idUser);
        Playlist p = u.getPlaylistById(idPlaylist);
        log.info("Solicitud completada");

        return p.dameCanciones();
    }

    @Override
    public void addUser(User user) {
        log.info("Se va a añadir un usuario al sistema");
        this.users.put(user.getId(),user);
        log.info("Se ha añadido el usuario " + user.getId() + " al sistema");

    }

    @Override
    public List<Playlist> dameListaPlaylistsByUser(String idUser) {
        return this.users.get(idUser).getPlaylists();
    }

    @Override
    public void clear() {
        this.users.clear();
        this.artistas.clear();

    }

    public boolean checkArtista(String idArtista){

        boolean check = false;

        for(Artista a : this.artistas){
            if(a.getId() == idArtista){
                check = true;
                break;
            }else {
                log.error("No se ha encontrado el Artista en el sistema");

            }


        }

        return check;

    }

    public int numArtistas(){
        return this.artistas.size();
    }

    public int numUsers(){
        return this.users.size();
    }


}
