package de.fst.scheckcheck.rest.endpunkt;

import de.fst.scheckcheck.entitaet.Portalmitarbeiter;
import de.fst.scheckcheck.integration.PortalmitarbeiterDbIntegrationsService;
import de.fst.scheckcheck.mapper.PortalmitarbeiterMapper;
import de.fst.scheckcheck.rest.ressource.PortalmitarbeiterRO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Endpunkt für {@link de.fst.scheckcheck.entitaet.Portalmitarbeiter}.
 */
@Stateless
@Path("/portalmitarbeiter")
public class PortalmitarbeiterEndpoint {

  @Inject
  private PortalmitarbeiterMapper portalmitarbeiterMapper;

  @Inject
  private PortalmitarbeiterDbIntegrationsService portalmitarbeiterDbIntegrationsService;

  /**
   * Erzeuge einen Portalmitarbeiter.
   *
   * @param ro Ressource Objekt
   * @return Response
   */
  @POST
  @Consumes("application/json")
  public Response erzeuge(PortalmitarbeiterRO ro) {
    Portalmitarbeiter entity = portalmitarbeiterMapper.vonRO(null, ro);
    portalmitarbeiterDbIntegrationsService.speicher(entity);
    return Response.created(
      UriBuilder.fromResource(PortalmitarbeiterEndpoint.class).path(String.valueOf(entity.getId())).build())
      .build();
  }

  /**
   * Lösche anhand der id.
   *
   * @param id id
   * @return Response
   */
  @DELETE
  @Path("/{id:[0-9][0-9]*}")
  public Response loesche(@PathParam("id") Long id) {
    Portalmitarbeiter portalmitarbeiter = portalmitarbeiterDbIntegrationsService.suche(id);
    if (portalmitarbeiter == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    portalmitarbeiterDbIntegrationsService.loesche(portalmitarbeiter);
    return Response.noContent().build();
  }

  /**
   * Suche anhand der id.
   *
   * @param id id
   * @return Response
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  @Produces("application/json")
  public Response suche(@PathParam("id") Long id) {
    Portalmitarbeiter portalmitarbeiter = portalmitarbeiterDbIntegrationsService.suche(id);
    if (portalmitarbeiter == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    PortalmitarbeiterRO ro = portalmitarbeiterMapper.vonEntitaet(null, portalmitarbeiter);
    return Response.ok(ro).build();
  }

  /**
   * Suche anhand des username.
   *
   * @param username username
   * @return Response
   */
  @GET
  @Path("/username/{username:[a-zA-Z][a-zA-Z_0-9]*}")
  @Produces("application/json")
  public Response sucheAnhandDesUsername(@PathParam("username") String username) {
    Portalmitarbeiter portalmitarbeiter = portalmitarbeiterDbIntegrationsService.sucheAnhandDesUsername(username);
    if (portalmitarbeiter == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    PortalmitarbeiterRO ro = portalmitarbeiterMapper.vonEntitaet(null, portalmitarbeiter);
    return Response.ok(ro).build();
  }

  /**
   * Liste alle Portalmitarbeiter auf.
   *
   * @return Alle Portalmitarbeiter
   */
  @GET
  @Produces("application/json")
  public Response listeAlleAuf() {
    List<Portalmitarbeiter> portalmitarbeiters = portalmitarbeiterDbIntegrationsService.listeAlleAuf();
    final List<PortalmitarbeiterRO> results = new ArrayList<>();
    for (Portalmitarbeiter portalmitarbeiter : portalmitarbeiters) {
      PortalmitarbeiterRO ro = portalmitarbeiterMapper.vonEntitaet(null, portalmitarbeiter);
      results.add(ro);
    }
    return Response.ok(results).build();
  }

  /**
   * Aktualisiere einen Portalmitarbeiter anhand des Ressource Objekts.
   *
   * @param id id
   * @param ro Ressource Objekt
   * @return Response
   */
  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes("application/json")
  public Response aktualisiere(@PathParam("id") Long id, PortalmitarbeiterRO ro) {
    Portalmitarbeiter entity = portalmitarbeiterDbIntegrationsService.suche(id);
    entity = portalmitarbeiterMapper.vonRO(entity, ro);
    portalmitarbeiterDbIntegrationsService.speicher(entity);
    return Response.noContent().build();
  }

}
