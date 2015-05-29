package de.fst.scheckcheck.entitaet;

import javax.persistence.*;

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
}
