package edu.upc.dsa;

import java.util.List;

public interface MyMusic {

    public void addArtista(Artista a);
    public List<Artista> dameListaArtistas();
    public void crearPlaylist(Cancion p);
    public void setTitlePlaylist(String idPlaylist);


    public void addUser(User user);
    public List<Cancion> dameListaPlaylist(String idUser);

    public void clear();




}
