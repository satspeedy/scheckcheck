package de.fst.scheckcheck.rest.endpunkt;

import de.fst.scheckcheck.entitaet.Bewertung;
import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.integration.BewertungDbIntegrationsService;
import de.fst.scheckcheck.integration.BildungsmassnahmeDbIntegrationsService;
import de.fst.scheckcheck.integration.BildungstraegerDbIntegrationsService;
import de.fst.scheckcheck.mapper.BildungsmassnahmeMapper;
import de.fst.scheckcheck.rest.ressource.BildungsmassnahmeRO;
import de.fst.scheckcheck.rest.ressource.full.BewertungFullRO;
import de.fst.scheckcheck.rest.ressource.full.BildungsmassnahmeFullRO;

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
public class BildungsmassnahmeEndpunkt {

  @Inject
  private BildungsmassnahmeMapper bildungsmassnahmeMapper;

  @Inject
  private BildungsmassnahmeDbIntegrationsService bildungsmassnahmeDbIntegrationsService;

  @Inject
  private BildungstraegerDbIntegrationsService bildungstraegerDbIntegrationsService;

  @Inject
  private BewertungDbIntegrationsService bewertungDbIntegrationsService;

  /**
   * Erzeuge eine Bildungsmassnahme.
   *
   * @param ro Ressource Objekt
   * @return Response
   *
   * FIXME save redundant
   */
  @POST
  @Consumes("application/json")
  public Response erzeuge(BildungsmassnahmeRO ro) {
    Bildungsmassnahme entity = bildungsmassnahmeMapper.vonRO(null, ro);
    // manuelles mapping
    entity.setBildungstraeger(bildungstraegerDbIntegrationsService.suche(ro.getBildungstraegerId()));
    for (Long bewertungId : ro.getBewertungIds()) {
      entity.getBewertungen().add(bewertungDbIntegrationsService.suche(bewertungId));
    }
    // manuelles mapping
    bildungsmassnahmeDbIntegrationsService.speicher(entity);
    return Response.created(
      UriBuilder.fromResource(BildungsmassnahmeEndpunkt.class).path(String.valueOf(entity.getId())).build())
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
    Bildungsmassnahme bildungsmassnahme = bildungsmassnahmeDbIntegrationsService.suche(id);
    if (bildungsmassnahme == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    bildungsmassnahmeDbIntegrationsService.loeschen(bildungsmassnahme);
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
    Bildungsmassnahme bildungsmassnahme = bildungsmassnahmeDbIntegrationsService.suche(id);
    if (bildungsmassnahme == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    BildungsmassnahmeFullRO ro = bildungsmassnahmeMapper.vonEntitaetFull(null, bildungsmassnahme);
    for (BewertungFullRO bewertungFullRO : ro.getBewertungen()) {
      bewertungFullRO.setBewertungDurchschnitt(berechneDurchschnitt(bewertungFullRO));
    }
    return Response.ok(ro).build();
  }

  private int berechneDurchschnitt(BewertungFullRO bewertungFullRO) {
    return (bewertungFullRO.getBewertungAusstattung() +
      bewertungFullRO.getBewertungDozenten() +
      bewertungFullRO.getBewertungInhaltWeiterbildung() +
      bewertungFullRO.getBewertungLehrveranstaltungen() +
      bewertungFullRO.getBewertungOrganisation() +
      bewertungFullRO.getBewertungPraxisnaehe() +
      bewertungFullRO.getBewertungUmsetzungWeiterbildung()) / 7;
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
    List<Bildungsmassnahme> bildungsmassnahmen = bildungsmassnahmeDbIntegrationsService.sucheAnhandDerBildungstraegerId(bildungstraegerId);
    if (bildungsmassnahmen == null || bildungsmassnahmen.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    final List<BildungsmassnahmeRO> results = new ArrayList<>();
    for (Bildungsmassnahme bildungsmassnahme : bildungsmassnahmen) {
      BildungsmassnahmeRO ro = bildungsmassnahmeMapper.vonEntitaet(null, bildungsmassnahme);
      // manuelles mapping
      ro.setBildungstraegerId(bildungsmassnahme.getId());
      for (Bewertung bewertung : bildungsmassnahme.getBewertungen()) {
        ro.getBewertungIds().add(bewertung.getId());
      }
      // manuelles mapping
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
    List<Bildungsmassnahme> bildungsmassnahmen = bildungsmassnahmeDbIntegrationsService.sucheAnhandDesNamen(name);
    if (bildungsmassnahmen == null || bildungsmassnahmen.isEmpty()) {
      return Response.status(Status.NOT_FOUND).build();
    }
    final List<BildungsmassnahmeRO> results = new ArrayList<>();
    for (Bildungsmassnahme bildungsmassnahme : bildungsmassnahmen) {
      BildungsmassnahmeRO ro = bildungsmassnahmeMapper.vonEntitaet(null, bildungsmassnahme);
      // manuelles mapping
      ro.setBildungstraegerId(bildungsmassnahme.getId());
      for (Bewertung bewertung : bildungsmassnahme.getBewertungen()) {
        ro.getBewertungIds().add(bewertung.getId());
      }
      // manuelles mapping
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
    List<Bildungsmassnahme> bildungsmassnahmen = bildungsmassnahmeDbIntegrationsService.listeAlleAuf();
    final List<BildungsmassnahmeRO> results = new ArrayList<>();
    for (Bildungsmassnahme bildungsmassnahme : bildungsmassnahmen) {
      BildungsmassnahmeRO ro = bildungsmassnahmeMapper.vonEntitaet(null, bildungsmassnahme);
      // manuelles mapping
      ro.setBildungstraegerId(bildungsmassnahme.getId());
      for (Bewertung bewertung : bildungsmassnahme.getBewertungen()) {
        ro.getBewertungIds().add(bewertung.getId());
      }
      // manuelles mapping
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
    Bildungsmassnahme entity = bildungsmassnahmeDbIntegrationsService.suche(id);
    entity = bildungsmassnahmeMapper.vonRO(entity, ro);
    // manuelles mapping
    entity.setBildungstraeger(bildungstraegerDbIntegrationsService.suche(ro.getBildungstraegerId()));
    for (Long bewertungId : ro.getBewertungIds()) {
      entity.getBewertungen().add(bewertungDbIntegrationsService.suche(bewertungId));
    }
    // manuelles mapping
    bildungsmassnahmeDbIntegrationsService.speicher(entity);
    return Response.noContent().build();
  }

}
