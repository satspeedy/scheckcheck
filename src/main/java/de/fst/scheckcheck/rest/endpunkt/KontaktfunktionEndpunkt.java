package de.fst.scheckcheck.rest.endpunkt;

import de.fst.scheckcheck.entitaet.Teilnehmer;
import de.fst.scheckcheck.integration.TeilnehmerDbIntegrationsService;
import de.fst.scheckcheck.rest.ressource.KontaktfunktionRO;
import de.fst.scheckcheck.service.EmailService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Endpunkt für {@link Teilnehmer}.
 */
@Stateless
@Path("/kontaktfunktion")
public class KontaktfunktionEndpunkt {

  @Inject
  private TeilnehmerDbIntegrationsService teilnehmerDbIntegrationsService;

  @Inject
  private EmailService emailService;

  /**
   * Erzeuge einen Teilnehmer.
   *
   * @param ro Ressource Objekt
   * @return Response
   */
  @POST
  @Consumes("application/json")
  public Response kontaktfunktion(KontaktfunktionRO ro) {
    Teilnehmer empfaenger = teilnehmerDbIntegrationsService.suche(ro.getEmpfaengerId());
    emailService.senden(empfaenger.getEmailAddresse(), ro.getBetreff(), ro.getNachricht());
    return Response.noContent().build();
  }

}
