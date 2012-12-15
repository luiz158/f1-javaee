package br.com.ibsoft.f1.rs;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.ibsoft.f1.entity.Equipe;
import br.com.ibsoft.f1.entity.Piloto;
import br.com.ibsoft.f1.entity.Temporada;
import br.com.ibsoft.f1.rs.exception.F1ExceptionRest;

@Path("/f1/temporadas")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
public interface F1Resource extends Serializable {

    @GET
    List<Temporada> listarTemporadas(@QueryParam("f") Integer first, @QueryParam("m") Integer max)
            throws F1ExceptionRest;

    @Path("/{id}")
    @GET
    Temporada buscarTemporadaPorId(@PathParam("id") Long id) throws F1ExceptionRest;

    @Path("/ano/{ano}")
    @GET
    Temporada buscarTemporadaPorAno(@PathParam("ano") Integer ano) throws F1ExceptionRest;

    @POST
    Temporada salvarTemporada(Temporada temporada) throws F1ExceptionRest;

    @PUT
    Temporada atualizarTemporada(Temporada temporada) throws F1ExceptionRest;

    @Path("/{id}")
    @DELETE
    void deletarTemporada(@PathParam("id") Long id) throws F1ExceptionRest;

    @GET
    @Path("/equipes")
    List<Equipe> listarEquipes(@QueryParam("f") Integer first, @QueryParam("m") Integer max) throws F1ExceptionRest;

    @Path("/equipes/{id}")
    @GET
    Equipe buscarEquipePorId(@PathParam("id") Long id) throws F1ExceptionRest;

    @POST
    @Path("/equipes")
    Equipe salvarEquipe(Equipe equipe) throws F1ExceptionRest;

    @PUT
    @Path("/equipes")
    Equipe atualizarEquipe(Equipe equipe) throws F1ExceptionRest;

    @Path("/equipes/{id}")
    @DELETE
    void deletarEquipe(@PathParam("id") Long id) throws F1ExceptionRest;

    @GET
    @Path("/pilotos")
    List<Piloto> listarPilotos(@QueryParam("f") Integer first, @QueryParam("m") Integer max) throws F1ExceptionRest;

    @Path("/pilotos/{id}")
    @GET
    Piloto buscarPilotoPorId(@PathParam("id") Long id) throws F1ExceptionRest;

    @POST
    @Path("/pilotos")
    Piloto salvarPiloto(Piloto piloto) throws F1ExceptionRest;

    @PUT
    @Path("/pilotos")
    Equipe atualizarPiloto(Piloto piloto) throws F1ExceptionRest;

    @Path("/pilotos/{id}")
    @DELETE
    void deletarPiloto(@PathParam("id") Long id) throws F1ExceptionRest;

}
