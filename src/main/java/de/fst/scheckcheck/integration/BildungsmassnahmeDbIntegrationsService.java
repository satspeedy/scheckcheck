package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.entitaet.Bildungstraeger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Datenbank Integrationsservice für Bildungsmassnahme.
 */
public class BildungsmassnahmeDbIntegrationsService {

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
   * @param bildungsmassnahme Teilnehmer
   * @return zusammengeführte instance
   */
  public Bildungsmassnahme speichern(Bildungsmassnahme bildungsmassnahme) {
    Bildungsmassnahme gespeicherteBildungsmassnahme = em.merge(bildungsmassnahme);
    logger.info("Entity mit id " + gespeicherteBildungsmassnahme.getId() + " gemerged!");
    return gespeicherteBildungsmassnahme;
  }

  /**
   * Sucht nach Bildungsmassnahme mit der gewünschten id.
   *
   * @param id id der zu suchenden Bildungsmassnahme.
   * @return gefundene entität oder null wenn keine entität existiert
   */
  public Bildungsmassnahme suchen(Long id) {
    return em.find(Bildungsmassnahme.class, id);
  }

  /**
   * Löscht die Entiät aus der Datenbank.
   *
   * @param bildungsmassnahme Bildungsmassnahme instanz
   */
  public void loeschen(Bildungsmassnahme bildungsmassnahme) {
      em.remove(bildungsmassnahme);
  }

  /**
   * Alle Bildungsmassnahmen auflisten.
   *
   * @return Liste aller Bildungsmassnahmen
   */
  public List<Bildungsmassnahme> listeAlleAuf() {
    return em.createQuery(
      "SELECT DISTINCT b FROM Bildungsmassnahme b ORDER BY b.id", Bildungsmassnahme.class).getResultList();
  }

  /**
   * Suche anhand des Bildungsträgers.
   *
   * @param bildungstraeger Bildungstraeger als Suchparameter
   * @return Liste von gefundenen entitäten oder eine leere Liste wenn keine entität existiert
   */
  public List<Bildungsmassnahme> suchenAnhandDesBildungstraegers(Bildungstraeger bildungstraeger) {
    TypedQuery<Bildungsmassnahme> findByBildungstraegerQuery = em.createQuery(
      "SELECT DISTINCT b FROM Bildungsmassnahme b WHERE b.bildungstraeger = :bildungstraeger ORDER BY b.id", Bildungsmassnahme.class);
    findByBildungstraegerQuery.setParameter("bildungstraeger", bildungstraeger);
    List<Bildungsmassnahme> bildungsmassnahmen;
    try {
      bildungsmassnahmen = findByBildungstraegerQuery.getResultList();
    } catch (NoResultException nre) {
      bildungsmassnahmen = new ArrayList<>();
    }
    return bildungsmassnahmen;
  }

  /**
   * Suche anhand des Namens.
   *
   * @param name Name der Bildungsmassnahme als Suchparameter
   * @return Liste von gefundenen entitäten oder eine leere Liste wenn keine entität existiert
   */
  public List<Bildungsmassnahme> suchenAnhandDesNamen(String name) {
    TypedQuery<Bildungsmassnahme> findByNameQuery = em.createQuery(
      "SELECT DISTINCT b FROM Bildungsmassnahme b WHERE b.name = :name ORDER BY b.id", Bildungsmassnahme.class);
    findByNameQuery.setParameter("name", name);
    List<Bildungsmassnahme> bildungsmassnahmen;
    try {
      bildungsmassnahmen = findByNameQuery.getResultList();
    } catch (NoResultException nre) {
      bildungsmassnahmen = new ArrayList<>();
    }
    return bildungsmassnahmen;
  }

}
