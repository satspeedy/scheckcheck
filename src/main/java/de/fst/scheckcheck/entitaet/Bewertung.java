package de.fst.scheckcheck.entitaet;

import javax.persistence.*;
import java.util.Date;

/**
 * Entität Bewertung.
 */
@Entity
@Table(name = "BEWERTUNG")
@NamedQuery(name = Bewertung.NQ_FINDE_ALLE, query = "SELECT b FROM Bewertung b")
public class Bewertung extends BasisEntitaet {

  public static final String NQ_FINDE_ALLE = "Evaluation.findeAlle";

  private static final long serialVersionUID = 1L;

  private Date datum;

  private String sternebewertung;

  @Column(name = "frei_text")
  private String freiText;

  public Bewertung() {
  }

  public Date getDatum() {
    return datum;
  }

  public void setDatum(Date datum) {
    this.datum = datum;
  }

  public String getSternebewertung() {
    return sternebewertung;
  }

  public void setSternebewertung(String sternebewertung) {
    this.sternebewertung = sternebewertung;
  }

  public String getFreiText() {
    return freiText;
  }

  public void setFreiText(String freiText) {
    this.freiText = freiText;
  }
}
