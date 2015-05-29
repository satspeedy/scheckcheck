package de.fst.scheckcheck.applikation;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Konfiguration des REST Kontext Pfades, unter dem applikationsweit alle REST Schnittstellen publiziert sind.
 */
@ApplicationPath("resources")
public class RestKonfiguration extends Application {

}
