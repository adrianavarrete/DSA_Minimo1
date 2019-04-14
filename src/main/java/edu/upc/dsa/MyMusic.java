package edu.upc.dsa;

import java.util.List;

public interface MyMusic {

    public void addArtista(Artista a);
    public List<Artista> dameListaArtistas();
    public void crearPlaylist(Playlist p);
    public void addCancionPlaylist(String idPlaylist, String idUser, Cancion c) throws PlaylistNotFoundException, ArtistaNotFoundException;
    public List<Cancion> dameListaPlaylistUser(String idUser, String idPlaylist) throws PlaylistNotFoundException;


    public void addUser(User user);
    public List<Playlist> dameListaPlaylistsByUser(String idUser);

    public void clear();
    public boolean checkArtista(String idArtista);
    public int numArtistas();
    public int numUsers();

}
