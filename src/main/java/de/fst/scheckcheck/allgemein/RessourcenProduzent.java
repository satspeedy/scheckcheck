package de.fst.scheckcheck.allgemein;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Erzeugt Context Dependency Injection (CDI) Ressourcen zum injizieren.
 *
 * Zum Beispiel den Persistenz Kontext.
 */
@ApplicationScoped
public class RessourcenProduzent {

  public static final String PERSISTENZ_EINHEIT_NAME = "scheckcheck-PU";

  @Produces
  @PersistenceContext(unitName = PERSISTENZ_EINHEIT_NAME)
  private EntityManager em;

  /**
   * Gibt einen angepassten Logger in Abhängigkeit von dem Injizierungs Punkt zurück.
   *
   * @param injizierungsPunkt
   *          aufrufende Klasse
   * @return {@link Logger}
   */
  @Produces
  public Logger produceLogger(InjectionPoint injizierungsPunkt) {
    return Logger.getLogger(injizierungsPunkt.getMember().getDeclaringClass().getName());
  }

}
