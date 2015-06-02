package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.entitaet.Bewertung;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/**
 * Datenbank Integrationsservice für Bewertung.
 */
public class BewertungDbIntegrationsService {

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
   * @param bewertung Bewertung
   * @return zusammengeführte instance
   */
  public Bewertung speichern(Bewertung bewertung) {
    Bewertung gespeicherteBewertung = em.merge(bewertung);
    logger.info("Entity mit id " + gespeicherteBewertung.getId() + " gemerged!");
    return gespeicherteBewertung;
  }

  /**
   * Sucht nach Bewertung mit der gewünschten id.
   *
   * @param id id der zu suchenden Bewertung.
   * @return gefundene entität oder null wenn keine entität existiert
   */
  public Bewertung suchen(Long id) {
    return em.find(Bewertung.class, id);
  }

  /**
   * Löscht die Entiät aus der Datenbank.
   *
   * @param bewertung Bewertung instanz
   */
  public void loeschen(Bewertung bewertung) {
      em.remove(bewertung);
  }

  /**
   * Alle Bewertungen auflisten.
   *
   * @return Liste aller Bewertungen
   */
  public List<Bewertung> listeAlleAuf() {
    return em.createQuery(
      "SELECT DISTINCT b FROM Bewertung b ORDER BY b.id", Bewertung.class).getResultList();
  }

}
