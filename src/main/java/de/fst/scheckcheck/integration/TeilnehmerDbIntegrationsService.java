package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.entitaet.Teilnehmer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * Datenbank Integrationsservice für Teilnehmer.
 */
public class TeilnehmerDbIntegrationsService {

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
   * @param teilnehmer Teilnehmer
   * @return zusammengeführte instance
   */
  public Teilnehmer speichern(Teilnehmer teilnehmer) {
    Teilnehmer gespeicherterTeilnehmer = em.merge(teilnehmer);
    logger.info("Entity mit id " + gespeicherterTeilnehmer.getId() + " gemerged!");
    return gespeicherterTeilnehmer;
  }

  /**
   * Sucht nach Teilnehmer mit der gewünschten id.
   *
   * @param id id des zu suchenden Teilnehmers.
   * @return gefundene entität oder null wenn keine entität existiert
   */
  public Teilnehmer suchen(Long id) {
    return em.find(Teilnehmer.class, id);
  }

  /**
   * Löscht die Entiät aus der Datenbank.
   *
   * @param teilnehmer Teilnehmer instanz
   */
  public void loeschen(Teilnehmer teilnehmer) {
      em.remove(teilnehmer);
  }

  /**
   * Alle Teilnehmer auflisten.
   *
   * @return Liste aller Teilnehmer
   */
  public List<Teilnehmer> listeAlleAuf() {
    return em.createQuery(
      "SELECT DISTINCT t FROM Teilnehmer t ORDER BY t.id", Teilnehmer.class).getResultList();
  }

  /**
   * Suche anhand des usernamen.
   *
   * @param username username
   * @return gefundene entität oder null wenn keine entität existiert
   */
  public Teilnehmer suchenAnhandDesUsername(String username) {
    TypedQuery<Teilnehmer> findByUsernameQuery = em.createQuery(
      "SELECT DISTINCT t FROM Teilnehmer t WHERE t.username = :username ORDER BY t.username", Teilnehmer.class);
    findByUsernameQuery.setParameter("username", username);
    Teilnehmer teilnehmer;
    try {
      teilnehmer = findByUsernameQuery.getSingleResult();
    } catch (NoResultException nre) {
      teilnehmer = null;
    }
    return teilnehmer;
  }

}
