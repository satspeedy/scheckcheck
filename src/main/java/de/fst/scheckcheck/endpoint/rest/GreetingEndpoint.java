package de.fst.scheckcheck.endpoint.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Endpoint for Ping.
 */
@Path("/greetings")
public class GreetingEndpoint {

  @GET
  public String message() {
    return "Hi REST!";
  }

  @POST
  public String lowerCase(final String message) {
    return message.toLowerCase();
  }

}
