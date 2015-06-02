package de.fst.scheckcheck.rest.endpunkt;

import de.fst.scheckcheck.entitaet.Bildungstraeger;
import de.fst.scheckcheck.integration.BildungstraegerDbIntegrationsService;
import de.fst.scheckcheck.mapper.BildungstraegerMapper;
import de.fst.scheckcheck.rest.ressource.BildungstraegerRO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Endpunkt für {@link de.fst.scheckcheck.entitaet.Bildungstraeger}.
 */
@Stateless
@Path("/bildungstraeger")
public class BildungstraegerEndpoint {

  @Inject
  private BildungstraegerMapper bildungstraegerMapper;

  @Inject
  private BildungstraegerDbIntegrationsService bildungstraegerDbIntegrationsService;

  /**
   * Erzeuge eine Bildungstraeger.
   *
   * @param ro Ressource Objekt
   * @return Response
   */
  @POST
  @Consumes("application/json")
  public Response erzeuge(BildungstraegerRO ro) {
    Bildungstraeger entity = bildungstraegerMapper.vonRO(null, ro);
    bildungstraegerDbIntegrationsService.speicher(entity);
    return Response.created(
      UriBuilder.fromResource(BildungstraegerEndpoint.class).path(String.valueOf(entity.getId())).build())
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
    Bildungstraeger bildungstraeger = bildungstraegerDbIntegrationsService.suche(id);
    if (bildungstraeger == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    bildungstraegerDbIntegrationsService.loesche(bildungstraeger);
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
    Bildungstraeger bildungstraeger = bildungstraegerDbIntegrationsService.suche(id);
    if (bildungstraeger == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    BildungstraegerRO ro = bildungstraegerMapper.vonEntitaet(null, bildungstraeger);
    return Response.ok(ro).build();
  }

  /**
   * Liste alle Bildungstraeger auf.
   *
   * @return Alle Bildungstraeger
   */
  @GET
  @Produces("application/json")
  public Response listeAlleAuf() {
    List<Bildungstraeger> bildungstraegers = bildungstraegerDbIntegrationsService.listeAlleAuf();
    final List<BildungstraegerRO> results = new ArrayList<>();
    for (Bildungstraeger bildungstraeger : bildungstraegers) {
      BildungstraegerRO ro = bildungstraegerMapper.vonEntitaet(null, bildungstraeger);
      results.add(ro);
    }
    return Response.ok(results).build();
  }

  /**
   * Aktualisiere einen Bildungstraeger anhand des Ressource Objekts.
   *
   * @param id id
   * @param ro Ressource Objekt
   * @return Response
   */
  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes("application/json")
  public Response aktualisiere(@PathParam("id") Long id, BildungstraegerRO ro) {
    Bildungstraeger entity = bildungstraegerDbIntegrationsService.suche(id);
    entity = bildungstraegerMapper.vonRO(entity, ro);
    bildungstraegerDbIntegrationsService.speicher(entity);
    return Response.noContent().build();
  }

}
