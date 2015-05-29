package de.fst.scheckcheck.allgemein;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.logging.Logger;

/**
 * Erzeugt Context Dependency Injection (CDI) Ressourcen zum injizieren für Tests.
 *
 * Zum Beispiel den Persistenz Kontext.
 */
@Alternative
public class TestRessourcenProduzent {

  public static final String PERSISTENZ_EINHEIT_NAME_FUER_TESTS = "test-scheckcheck-PU";

  @Produces
  @Alternative
  public EntityManager produceEntityManager() {
    return Persistence.createEntityManagerFactory(PERSISTENZ_EINHEIT_NAME_FUER_TESTS).createEntityManager();
  }

  /**
   * Gibt einen angepassten Logger in Abhängigkeit von dem Injizierungs Punkt zurück.
   *
   * @param injizierungsPunkt
   *          aufrufende Klasse
   * @return {@link Logger}
   */
  @Produces
  @Alternative
  public Logger produceLogger(InjectionPoint injizierungsPunkt) {
    return Logger.getLogger(injizierungsPunkt.getMember().getDeclaringClass().getName());
  }

}
