package edu.upc.dsa.services;


import edu.upc.dsa.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/MyMusic", description = "Servicio de Música de la EETAC")
@Path("/MyMusic")
public class MyMusicServices {

    private MyMusic mm;

    public MyMusicServices() throws ArtistaNotFoundException, PlaylistNotFoundException {
        this.mm = MyMusicImpl.getInstance();

        if(mm.numArtistas() == 0 && mm.numUsers() == 0){
            mm.addUser(new User("user1","Adri","Navarrete"));
            mm.addArtista(new Artista("artista1","Manolo","Escobar"));
            mm.crearPlaylist(new Playlist("playlist1","mi música","user1"));
            mm.addCancionPlaylist("playlist1","user1",new Cancion("cancion1","Mi carro","artista1",120,"Mis Exitos"));
            mm.addCancionPlaylist("playlist1","user1",new Cancion("cancion2","Poronmpompero","artista1",120,"Mis Exitos"));


        }

    }


    @POST
    @ApiOperation(value = "Añadir un artista")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Artista.class)
    })
    @Path("/artistas/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response añadirArtista(Artista a) {

        this.mm.addArtista(a);
        return Response.status(201).build();
    }


    @GET
    @ApiOperation(value = "Dame el listado de artistas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Artista.class, responseContainer = "lista")

    })
    @Path("/artistas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameListaArtistas() {


        List<Artista> artistas = this.mm.dameListaArtistas();
        GenericEntity<List<Artista>> entity = new GenericEntity<List<Artista>>(artistas){};
        return Response.status(201).entity(entity).build();


    }

    @POST
    @ApiOperation(value = "crear una playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/Playlists")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearPlaylist(PlaylistTO p) {

        this.mm.crearPlaylist(new Playlist(p.getId(),p.getNombre(),p.getIdUser()));
        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "añadir canción playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/users/{idPlaylist}/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCancionPlaylist(@PathParam("idPlaylist") String idPlaylist,@PathParam("idUser") String idUser,Cancion c) throws ArtistaNotFoundException, PlaylistNotFoundException {

        this.mm.addCancionPlaylist(idPlaylist,idUser,c);
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Dame el listado de playlists de un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Playlist.class, responseContainer = "lista")

    })
    @Path("/{idUser}/playlists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response damePlaylists(@PathParam("idUser") String idUser) {


        List<Playlist> playlists = this.mm.dameListaPlaylistsByUser(idUser);
        GenericEntity<List<Playlist>> entity = new GenericEntity<List<Playlist>>(playlists){};
        return Response.status(201).entity(entity).build();


    }
    @GET
    @ApiOperation(value = "Dame canciones de la playlist de un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Playlist.class, responseContainer = "lista")

    })
    @Path("/{idUser}/{idPlaylist}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameListaPlaylistUser(@PathParam("idUser") String idUser, @PathParam("idPlaylist") String idPlaylist) throws PlaylistNotFoundException {


        List<Cancion> canciones = this.mm.dameListaPlaylistUser(idUser,idPlaylist);
        GenericEntity<List<Cancion>> entity = new GenericEntity<List<Cancion>>(canciones){};
        return Response.status(201).entity(entity).build();


    }






}
