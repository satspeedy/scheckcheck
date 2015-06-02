package de.fst.scheckcheck.rest.endpunkt;

import de.fst.scheckcheck.entitaet.Bewertung;
import de.fst.scheckcheck.integration.BewertungDbIntegrationsService;
import de.fst.scheckcheck.mapper.BewertungMapper;
import de.fst.scheckcheck.rest.ressource.BewertungRO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Endpunkt für {@link de.fst.scheckcheck.entitaet.Bewertung}.
 */
@Stateless
@Path("/bewertung")
public class BewertungEndpunkt {

  @Inject
  private BewertungMapper bewertungMapper;

  @Inject
  private BewertungDbIntegrationsService bewertungDbIntegrationsService;

  /**
   * Erzeuge eine Bewertung.
   *
   * @param ro Ressource Objekt
   * @return Response
   */
  @POST
  @Consumes("application/json")
  public Response erzeuge(BewertungRO ro) {
    Bewertung entity = bewertungMapper.vonRO(null, ro);
    bewertungDbIntegrationsService.speicher(entity);
    return Response.created(
      UriBuilder.fromResource(BewertungEndpunkt.class).path(String.valueOf(entity.getId())).build())
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
    Bewertung bewertung = bewertungDbIntegrationsService.suche(id);
    if (bewertung == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    bewertungDbIntegrationsService.loesche(bewertung);
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
    Bewertung bewertung = bewertungDbIntegrationsService.suche(id);
    if (bewertung == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    BewertungRO ro = bewertungMapper.vonEntitaet(null, bewertung);
    return Response.ok(ro).build();
  }

  /**
   * Liste alle Bewertungen auf.
   *
   * @return Alle Bewertungen
   */
  @GET
  @Produces("application/json")
  public Response listeAlleAuf() {
    List<Bewertung> bewertungen = bewertungDbIntegrationsService.listeAlleAuf();
    final List<BewertungRO> results = new ArrayList<>();
    for (Bewertung bewertung : bewertungen) {
      BewertungRO ro = bewertungMapper.vonEntitaet(null, bewertung);
      results.add(ro);
    }
    return Response.ok(results).build();
  }

  /**
   * Aktualisiere eine Bewertung anhand des Ressource Objekts.
   *
   * @param id id
   * @param ro Ressource Objekt
   * @return Response
   */
  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes("application/json")
  public Response aktualisiere(@PathParam("id") Long id, BewertungRO ro) {
    Bewertung entity = bewertungDbIntegrationsService.suche(id);
    entity = bewertungMapper.vonRO(entity, ro);
    bewertungDbIntegrationsService.speicher(entity);
    return Response.noContent().build();
  }

}
