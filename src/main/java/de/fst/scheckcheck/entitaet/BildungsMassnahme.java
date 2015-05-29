package de.fst.scheckcheck.entitaet;

import javax.persistence.*;

/**
 * Entität Bildungsmaßnahme.
 */
@Entity
@Table(name = "BILDUNGS_MASSNAHME")
@NamedQuery(name = BildungsMassnahme.NQ_FINDE_ALLE, query = "SELECT b FROM BildungsMassnahme b")
public class BildungsMassnahme extends BasisEntitaet {

  public static final String NQ_FINDE_ALLE = "TrainingMeasure.findeAlle";

  private static final long serialVersionUID = 1L;

  private String name;

  private String ort;

  private String beschreibung;

  public BildungsMassnahme() {
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

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }
}
