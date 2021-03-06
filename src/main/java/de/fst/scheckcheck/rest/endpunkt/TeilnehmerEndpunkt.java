package de.fst.scheckcheck.rest.endpunkt;

import de.fst.scheckcheck.entitaet.Bewertung;
import de.fst.scheckcheck.entitaet.Teilnehmer;
import de.fst.scheckcheck.integration.BewertungDbIntegrationsService;
import de.fst.scheckcheck.integration.TeilnehmerDbIntegrationsService;
import de.fst.scheckcheck.mapper.TeilnehmerMapper;
import de.fst.scheckcheck.rest.ressource.TeilnehmerRO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * REST Endpunkt für {@link de.fst.scheckcheck.entitaet.Teilnehmer}.
 */
@Stateless
@Path("/teilnehmer")
public class TeilnehmerEndpunkt {

  @Inject
  private TeilnehmerMapper teilnehmerMapper;

  @Inject
  private TeilnehmerDbIntegrationsService teilnehmerDbIntegrationsService;

  @Inject
  private BewertungDbIntegrationsService bewertungDbIntegrationsService;

  /**
   * Erzeuge einen Teilnehmer.
   *
   * @param ro Ressource Objekt
   * @return Response
   */
  @POST
  @Consumes("application/json")
  public Response erzeuge(TeilnehmerRO ro) {
    Teilnehmer entity = teilnehmerMapper.vonRO(null, ro);
    // manuelles mapping
    for (Long bewertungId : ro.getBewertungIds()) {
      entity.getBewertungen().add(bewertungDbIntegrationsService.suche(bewertungId));
    }
    // manuelles mapping
    teilnehmerDbIntegrationsService.speicher(entity);
    return Response.created(
      UriBuilder.fromResource(TeilnehmerEndpunkt.class).path(String.valueOf(entity.getId())).build())
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
    Teilnehmer teilnehmer = teilnehmerDbIntegrationsService.suche(id);
    if (teilnehmer == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    teilnehmerDbIntegrationsService.loesche(teilnehmer);
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
    Teilnehmer teilnehmer = teilnehmerDbIntegrationsService.suche(id);
    if (teilnehmer == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    TeilnehmerRO ro = teilnehmerMapper.vonEntitaet(null, teilnehmer);
    // manuelles mapping
    for (Bewertung bewertung : teilnehmer.getBewertungen()) {
      ro.getBewertungIds().add(bewertung.getId());
    }
    // manuelles mapping
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
    Teilnehmer teilnehmer = teilnehmerDbIntegrationsService.sucheAnhandDesUsername(username);
    if (teilnehmer == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    TeilnehmerRO ro = teilnehmerMapper.vonEntitaet(null, teilnehmer);
    // manuelles mapping
    for (Bewertung bewertung : teilnehmer.getBewertungen()) {
      ro.getBewertungIds().add(bewertung.getId());
    }
    // manuelles mapping
    return Response.ok(ro).build();
  }

  /**
   * Liste alle Teilnehmer auf.
   *
   * @return Alle Teilnehmer
   */
  @GET
  @Produces("application/json")
  public Response listeAlleAuf() {
    List<Teilnehmer> teilnehmers = teilnehmerDbIntegrationsService.listeAlleAuf();
    final List<TeilnehmerRO> results = new ArrayList<>();
    for (Teilnehmer teilnehmer : teilnehmers) {
      TeilnehmerRO ro = teilnehmerMapper.vonEntitaet(null, teilnehmer);
      // manuelles mapping
      for (Bewertung bewertung : teilnehmer.getBewertungen()) {
        ro.getBewertungIds().add(bewertung.getId());
      }
      // manuelles mapping
      results.add(ro);
    }
    return Response.ok(results).build();
  }

  /**
   * Aktualisiere einen Teilnehmer anhand des Ressource Objekts.
   *
   * @param id id
   * @param ro Ressource Objekt
   * @return Response
   */
  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes("application/json")
  public Response aktualisiere(@PathParam("id") Long id, TeilnehmerRO ro) {
    Teilnehmer entity = teilnehmerDbIntegrationsService.suche(id);
    entity = teilnehmerMapper.vonRO(entity, ro);
    // manuelles mapping
    for (Long bewertungId : ro.getBewertungIds()) {
      entity.getBewertungen().add(bewertungDbIntegrationsService.suche(bewertungId));
    }
    // manuelles mapping
    teilnehmerDbIntegrationsService.speicher(entity);
    return Response.noContent().build();
  }

}
