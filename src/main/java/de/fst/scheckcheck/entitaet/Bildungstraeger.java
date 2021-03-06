package de.fst.scheckcheck.entitaet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entität Bildungsträger.
 */
@Entity
@Table(name = "BILDUNGSTRAEGER")
@NamedQuery(name = Bildungstraeger.NQ_FINDE_ALLE, query = "SELECT b FROM Bildungstraeger b")
public class Bildungstraeger extends BasisEntitaet {

  public static final String NQ_FINDE_ALLE = "Bildungstraeger.findeAlle";

  private static final long serialVersionUID = 1L;

  private String name;

  private String ort;

  @Column(name = "kontakt_daten")
  private String kontaktdaten;

  private String beschreibung;

  private String angebot;

  @OneToMany(mappedBy = "bildungstraeger", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
  private List<Bildungsmassnahme> bildungsmassnahmen = new ArrayList<>();

  public Bildungstraeger() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public String getKontaktdaten() {
    return kontaktdaten;
  }

  public void setKontaktdaten(String kontaktdaten) {
    this.kontaktdaten = kontaktdaten;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }

  public String getAngebot() {
    return angebot;
  }

  public void setAngebot(String angebot) {
    this.angebot = angebot;
  }

  public List<Bildungsmassnahme> getBildungsmassnahmen() {
    return bildungsmassnahmen;
  }

  public void setBildungsmassnahmen(List<Bildungsmassnahme> bildungsMassnahmen) {
    this.bildungsmassnahmen = bildungsMassnahmen;
  }

  /**
   * Fügt dem Bildungstraeger eine Bildungsmassnahme hinzu.
   *
   * @param bildungsmassnahme Bildungsmassnahme
   */
  public void fuegeBildungsmassnahmeHinzu(Bildungsmassnahme bildungsmassnahme) {
    this.bildungsmassnahmen.add(bildungsmassnahme);
    if (bildungsmassnahme != null && bildungsmassnahme.getBildungstraeger() != this) {
      bildungsmassnahme.setBildungstraeger(this);
    }
  }

}
