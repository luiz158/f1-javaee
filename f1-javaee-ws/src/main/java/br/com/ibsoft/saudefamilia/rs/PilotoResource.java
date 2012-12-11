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

@Path("/pilotos")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
public interface PilotoResource extends Serializable {

    @GET
    List<Piloto> listarPilotos(@QueryParam("f") Integer first, @QueryParam("m") Integer max);

    @Path("/{id}")
    @GET
    Piloto buscarPilotoPorId(@PathParam("id") Long id);

    @POST
    Piloto salvarPiloto(Piloto piloto);

    @PUT
    Equipe atualizarPiloto(Piloto piloto);

    @Path("/{id}")
    @DELETE
    void deletarPiloto(@PathParam("id") Long id);

}
