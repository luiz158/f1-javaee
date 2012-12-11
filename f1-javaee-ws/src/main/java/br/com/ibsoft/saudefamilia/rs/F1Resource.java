package br.com.ibsoft.saudefamilia.rs;

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

@Path("/f1/temporadas")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
public interface F1Resource extends Serializable {

    @GET
    List<Temporada> listarTemporadas(@QueryParam("f") Integer first, @QueryParam("m") Integer max);

    @Path("/{id}")
    @GET
    Temporada buscarTemporadaPorId(@PathParam("id") Long id);

    @Path("/ano/{ano}")
    @GET
    Temporada buscarTemporadaPorAno(@PathParam("ano") Integer ano);

    @POST
    Temporada salvarTemporada(Temporada temporada);

    @PUT
    Temporada atualizarTemporada(Temporada temporada);

    @Path("/{id}")
    @DELETE
    void deletarTemporada(@PathParam("id") Long id);

    @GET
    @Path("/equipes")
    List<Equipe> listarEquipes(@QueryParam("f") Integer first, @QueryParam("m") Integer max);

    @Path("/equipes/{id}")
    @GET
    Equipe buscarEquipePorId(@PathParam("id") Long id);

    @POST
    @Path("/equipes")
    Equipe salvarEquipe(Equipe equipe);

    @PUT
    @Path("/equipes")
    Equipe atualizarEquipe(Equipe equipe);

    @Path("/equipes/{id}")
    @DELETE
    void deletarEquipe(@PathParam("id") Long id);

    @GET
    @Path("/pilotos")
    List<Piloto> listarPilotos(@QueryParam("f") Integer first, @QueryParam("m") Integer max);

    @Path("/pilotos/{id}")
    @GET
    Piloto buscarPilotoPorId(@PathParam("id") Long id);

    @POST
    @Path("/pilotos")
    Piloto salvarPiloto(Piloto piloto);

    @PUT
    @Path("/pilotos")
    Equipe atualizarPiloto(Piloto piloto);

    @Path("/pilotos/{id}")
    @DELETE
    void deletarPiloto(@PathParam("id") Long id);

}
