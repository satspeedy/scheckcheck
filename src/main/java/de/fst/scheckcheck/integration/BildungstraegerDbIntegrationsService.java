package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.entitaet.Bildungstraeger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/**
 * Datenbank Integrationsservice für Bildungstraeger.
 */
public class BildungstraegerDbIntegrationsService {

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
   * @param bildungstraeger Bildungstraeger
   * @return zusammengeführte instance
   */
  public Bildungstraeger speicher(Bildungstraeger bildungstraeger) {
    Bildungstraeger gespeicherterBildungstraeger = em.merge(bildungstraeger);
    logger.info("Entity mit id " + gespeicherterBildungstraeger.getId() + " gemerged!");
    return gespeicherterBildungstraeger;
  }

  /**
   * Sucht nach Bildungstraeger mit der gewünschten id.
   *
   * @param id id des zu suchenden Bildungstraegers.
   * @return gefundene entität oder null wenn keine entität existiert
   */
  public Bildungstraeger suche(Long id) {
    return em.find(Bildungstraeger.class, id);
  }

  /**
   * Löscht die Entiät aus der Datenbank.
   *
   * @param bildungstraeger Bildungstraeger instanz
   */
  public void loesche(Bildungstraeger bildungstraeger) {
      em.remove(bildungstraeger);
  }

  /**
   * Alle Bildungstraeger auflisten.
   *
   * @return Liste aller Bildungstraeger
   */
  public List<Bildungstraeger> listeAlleAuf() {
    return em.createQuery(
      "SELECT DISTINCT b FROM Bildungstraeger b ORDER BY b.id", Bildungstraeger.class).getResultList();
  }

}
