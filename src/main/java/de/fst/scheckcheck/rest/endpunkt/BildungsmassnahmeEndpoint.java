package de.fst.scheckcheck.rest.endpunkt;

import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.integration.BildungsmassnahmeDbIntegrationService;
import de.fst.scheckcheck.mapper.BildungsmassnahmeMapper;
import de.fst.scheckcheck.rest.ressource.BildungsmassnahmeRO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Endpunkt für {@link de.fst.scheckcheck.entitaet.Bildungsmassnahme}.
 */
@Stateless
@Path("/bildungsmassnahme")
public class BildungsmassnahmeEndpoint {

  @Inject
  private BildungsmassnahmeMapper bildungsmassnahmeMapper;

  @Inject
  private BildungsmassnahmeDbIntegrationService bildungsmassnahmeDbIntegrationService;

  /**
   * Erzeuge eine Bildungsmassnahme.
   *
   * @param ro Ressource Objekt
   * @return Response
   */
  @POST
  @Consumes("application/json")
  public Response erzeuge(BildungsmassnahmeRO ro) {
    Bildungsmassnahme entity = bildungsmassnahmeMapper.vonRO(null, ro);
    bildungsmassnahmeDbIntegrationService.speicher(entity);
    return Response.created(
      UriBuilder.fromResource(BildungsmassnahmeEndpoint.class).path(String.valueOf(entity.getId())).build())
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
    Bildungsmassnahme bildungsmassnahme = bildungsmassnahmeDbIntegrationService.suche(id);
    if (bildungsmassnahme == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    bildungsmassnahmeDbIntegrationService.loeschen(bildungsmassnahme);
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
    Bildungsmassnahme bildungsmassnahme = bildungsmassnahmeDbIntegrationService.suche(id);
    if (bildungsmassnahme == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    BildungsmassnahmeRO ro = bildungsmassnahmeMapper.vonEntitaet(null, bildungsmassnahme);
    return Response.ok(ro).build();
  }

  /**
   * Suche anhand der Bildungstraeger id.
   *
   * @param bildungstraegerId id des Bildungstraegers
   * @return Response
   */
  @GET
  @Path("/bildungstraeger/id/{id:[0-9][0-9]*}")
  @Produces("application/json")
  public Response sucheAnhandDerBildungstraegerId(@PathParam("id") Long bildungstraegerId) {
    List<Bildungsmassnahme> bildungsmassnahmen = bildungsmassnahmeDbIntegrationService.sucheAnhandDerBildungstraegerId(bildungstraegerId);
    if (bildungsmassnahmen == null || bildungsmassnahmen.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    final List<BildungsmassnahmeRO> results = new ArrayList<>();
    for (Bildungsmassnahme bildungsmassnahme : bildungsmassnahmen) {
      BildungsmassnahmeRO ro = bildungsmassnahmeMapper.vonEntitaet(null, bildungsmassnahme);
      results.add(ro);
    }
    return Response.ok(results).build();
  }
  /**
   * Suche anhand des Namen.
   *
   * @param name name der Bildungsmassnahme
   * @return Response
   */
  @GET
  @Path("/name/{name:[a-zA-Z][a-zA-Z_0-9]*}")
  @Produces("application/json")
  public Response sucheAnhandDesNamen(@PathParam("name") String name) {
    List<Bildungsmassnahme> bildungsmassnahmen = bildungsmassnahmeDbIntegrationService.sucheAnhandDesNamen(name);
    if (bildungsmassnahmen == null || bildungsmassnahmen.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    final List<BildungsmassnahmeRO> results = new ArrayList<>();
    for (Bildungsmassnahme bildungsmassnahme : bildungsmassnahmen) {
      BildungsmassnahmeRO ro = bildungsmassnahmeMapper.vonEntitaet(null, bildungsmassnahme);
      results.add(ro);
    }
    return Response.ok(results).build();
  }
  /**
   * Liste alle Bildungsmassnahmen auf.
   *
   * @return Alle Bildungsmassnahmen
   */
  @GET
  @Produces("application/json")
  public Response listeAlleAuf() {
    List<Bildungsmassnahme> bildungsmassnahmen = bildungsmassnahmeDbIntegrationService.listeAlleAuf();
    final List<BildungsmassnahmeRO> results = new ArrayList<>();
    for (Bildungsmassnahme bildungsmassnahme : bildungsmassnahmen) {
      BildungsmassnahmeRO ro = bildungsmassnahmeMapper.vonEntitaet(null, bildungsmassnahme);
      results.add(ro);
    }
    return Response.ok(results).build();
  }

  /**
   * Aktualisiere eine Bildungsmassnahme anhand des Ressource Objekts.
   *
   * @param id id
   * @param ro Ressource Objekt
   * @return Response
   */
  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes("application/json")
  public Response aktualisiere(@PathParam("id") Long id, BildungsmassnahmeRO ro) {
    Bildungsmassnahme entity = bildungsmassnahmeDbIntegrationService.suche(id);
    entity = bildungsmassnahmeMapper.vonRO(entity, ro);
    bildungsmassnahmeDbIntegrationService.speicher(entity);
    return Response.noContent().build();
  }

}
