package edu.upc.dsa;



import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class MyMusicTest {

    private MyMusic mm;
    private final static Logger log = Logger.getLogger(MyMusicTest.class.getName());

    @Before
    public void setUp() {

        mm = MyMusicImpl.getInstance();

        mm.addUser(new User("user1","Adri","Navarrete"));

    }

    @After
    public void limpiar(){

        this.mm.clear();
    }

    @Test
    public void crearPlaylistTest() {

        this.mm.crearPlaylist(new Cancion("1","cancion1","juan",15));
        assertEquals(1,this.mm.dameListaPlaylist("user1").size());


    }






}
