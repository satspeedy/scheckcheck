package de.fst.scheckcheck.rest.endpunkt;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Endpunkt zum Pingen.
 */
@Path("/gruesse")
public class GruesseEndpunkt {

  /**
   * Begruesst mit 'Hi REST'.
   *
   * @return gruesse
   */
  @GET
  public String message() {
    return "Hi REST!";
  }

  /**
   * Wandelt in kleine Buchstaben um.
   *
   * @param message eingabe text
   * @return ausgabe text
   */
  @POST
  public String lowerCase(final String message) {
    return message.toLowerCase();
  }

}
