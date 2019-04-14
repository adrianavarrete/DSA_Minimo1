package edu.upc.dsa;



import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class MyMusicTest {

    private MyMusic mm;


    @Before
    public void setUp() throws ArtistaNotFoundException, PlaylistNotFoundException {

        mm = MyMusicImpl.getInstance();

        mm.addUser(new User("user1","Adri","Navarrete"));
        mm.addArtista(new Artista("artista1","Manolo","Escobar"));
        mm.crearPlaylist(new Playlist("playlist1","mi música","user1"));
        mm.addCancionPlaylist("playlist1","user1",new Cancion("cancion1","Mi carro","artista1",120,"Mis Exitos"));


    }

    @After
    public void limpiar(){

        this.mm.clear();
    }

    @Test
    public void crearPlaylistTest() {

        this.mm.crearPlaylist(new Playlist("playlist2","mi música vol2","user1"));
        assertEquals(2,mm.dameListaPlaylistsByUser("user1").size());

    }
    @Test
    public void añadirCancionPlaylistUserTest() throws ArtistaNotFoundException, PlaylistNotFoundException {
        this.mm.addCancionPlaylist("playlist1","user1",new Cancion("cancion2","El Porompompero","artista1",120,"Mis Exitos"));

    }
    @Test
    public void dameListadoDeUnaPlaylistByUserTest() throws PlaylistNotFoundException {

        List<Cancion> lista = mm.dameListaPlaylistUser("user1","playlist1");
        assertEquals(1,lista.size());
    }





}
