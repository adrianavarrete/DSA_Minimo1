package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyMusicImpl implements MyMusic {

    private final static Logger log = Logger.getLogger(MyMusic.class.getName());
    private static MyMusicImpl instance;
    private static HashMap<String, User> users;
    private static List<Playlist> playlists;
    private static List<Artista> artistas;


    private MyMusicImpl() {

        this.users = new HashMap<>();
        this.playlists = new ArrayList<>();
        this.artistas = new LinkedList<>();


    }


    public static MyMusic getInstance() {
        if (instance == null) instance = new MyMusicImpl();
        return instance;
    }


    @Override
    public void addArtista(Artista a) {

        log.info("añado artista " + a.getNombre());
        this.artistas.add(a);
        log.info("añadido");

    }

    public void addCancion(Cancion c, String idPlaylist, User u){

        this.playlists.get(getPosListaById(idPlaylist)).addCancion(c);


    }

    @Override
    public List<Artista> dameListaArtistas() {
        return this.artistas;
    }

    @Override
    public void crearPlaylist(Cancion p) {

    }

    @Override
    public void crearPlaylist(Playlist p, String idUser) {

        this.playlists.add(p);
        this.users.get(idUser).añadirPlaylist();

    }

    @Override
    public void setTitlePlaylist(String idPlaylist) {

    }

    @Override
    public void addUser(User user) {
        this.users.put(user.getId(),user);
    }

    @Override
    public List<Playlist> dameListaPlaylist(String idUser) {
        return this.playlists;
    }

    @Override
    public void clear() {
        this.users.clear();
        this.playlists.clear();
        this.artistas.clear();
    }

    public int getPosListaById(List<Playlist> lista, String id) {

        int pos = -1;

        for(Playlist p: lista)
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

            log.error("Pedido " + id + " no encontrado");



        }

    }









}
