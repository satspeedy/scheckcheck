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

  public static final String NQ_FINDE_ALLE = "Bewertung.findeAlle";

  private static final long serialVersionUID = 1L;

  private Date datum;

  private String sternebewertung;

  @Column(name = "frei_text")
  private String freiText;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "teilnehmer_id", nullable = false)
  private Teilnehmer teilnehmer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bildungsmassnahme_id", nullable = false)
  private Bildungsmassnahme bildungsmassnahme;

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

  public Teilnehmer getTeilnehmer() {
    return teilnehmer;
  }

  /**
   * Setzt Teilnehmer.
   *
   * @param teilnehmer Teilnehmer
   */
  public void setTeilnehmer(Teilnehmer teilnehmer) {
    this.teilnehmer = teilnehmer;
    if (teilnehmer != null && !teilnehmer.getBewertungen().contains(this)) {
      teilnehmer.getBewertungen().add(this);
    }
  }

  public Bildungsmassnahme getBildungsmassnahme() {
    return bildungsmassnahme;
  }

  /**
   * Setzt Bildungsmassnahme.
   *
   * @param bildungsmassnahme Bildungsmassnahme
   */
  public void setBildungsmassnahme(Bildungsmassnahme bildungsmassnahme) {
    this.bildungsmassnahme = bildungsmassnahme;
    if (bildungsmassnahme != null && !bildungsmassnahme.getBewertungen().contains(this)) {
      bildungsmassnahme.getBewertungen().add(this);
    }
  }

}
