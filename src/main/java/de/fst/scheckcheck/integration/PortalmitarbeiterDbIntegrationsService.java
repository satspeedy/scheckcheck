package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.entitaet.Portalmitarbeiter;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * Datenbank Integrationsservice für Portalmitarbeiter.
 */
public class PortalmitarbeiterDbIntegrationsService {

  @Inject
  private Logger logger;

  @Inject
  private EntityManager em;

  /**
   * Nur für Tests zu verwenden.
   *
   * @return aktueller EntityManager
   */
  EntityManager getEm() {
    return em;
  }

  /**
   * Nur für Tests zu verwenden.
   *
   * @param em neuer EntityManager
   */
  void setEm(EntityManager em) {
    this.em = em;
  }

  /**
   * Speichert und gibt das zusammengeführte resultat zurück.
   *
   * @param portalmitarbeiter Teilnehmer
   * @return zusammengeführte instance
   */
  public Portalmitarbeiter speicher(Portalmitarbeiter portalmitarbeiter) {
    Portalmitarbeiter gespeicherterPortalmiarbeiter = em.merge(portalmitarbeiter);
    logger.info("Entity mit id " + gespeicherterPortalmiarbeiter.getId() + " gemerged!");
    return gespeicherterPortalmiarbeiter;
  }

  /**
   * Sucht nach Portalmitarbeiter mit der gewünschten id.
   *
   * @param id id des zu suchenden Teilnehmers.
   * @return gefundene entität oder null wenn keine entität existiert
   */
  public Portalmitarbeiter suche(Long id) {
    return em.find(Portalmitarbeiter.class, id);
  }

  /**
   * Löscht die Entiät aus der Datenbank.
   *
   * @param portalmitarbeiter Portalmitarbeiter instanz
   */
  public void loesche(Portalmitarbeiter portalmitarbeiter) {
      em.remove(portalmitarbeiter);
  }

  /**
   * Alle Teilnehmer auflisten.
   *
   * @return Liste aller Teilnehmer
   */
  public List<Portalmitarbeiter> listeAlleAuf() {
    return em.createQuery(
      "SELECT DISTINCT p FROM Portalmitarbeiter p ORDER BY p.id", Portalmitarbeiter.class).getResultList();
  }

  /**
   * Suche anhand des usernamen.
   *
   * @param username username
   * @return gefundene entität oder null wenn keine entität existiert
   */
  public Portalmitarbeiter sucheAnhandDesUsername(String username) {
    TypedQuery<Portalmitarbeiter> findByUsernameQuery = em.createQuery(
      "SELECT DISTINCT p FROM Portalmitarbeiter p WHERE p.username = :username ORDER BY p.username", Portalmitarbeiter.class);
    findByUsernameQuery.setParameter("username", username);
    Portalmitarbeiter portalmitarbeiter;
    try {
      portalmitarbeiter = findByUsernameQuery.getSingleResult();
    } catch (NoResultException nre) {
      portalmitarbeiter = null;
    }
    return portalmitarbeiter;
  }

}
