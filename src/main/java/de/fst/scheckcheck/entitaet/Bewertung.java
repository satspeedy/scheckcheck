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

  private int bewertungInhaltWeiterbildung;

  private int bewertungUmsetzungWeiterbildung;

  private int bewertungPraxisnaehe;

  private int bewertungLehrveranstaltungen;

  private int bewertungDozenten;

  private int bewertungOrganisation;

  private int bewertungAusstattung;

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

  public int getBewertungInhaltWeiterbildung() {
    return bewertungInhaltWeiterbildung;
  }

  public void setBewertungInhaltWeiterbildung(int bewertungInhaltWeiterbildung) {
    this.bewertungInhaltWeiterbildung = bewertungInhaltWeiterbildung;
  }

  public int getBewertungUmsetzungWeiterbildung() {
    return bewertungUmsetzungWeiterbildung;
  }

  public void setBewertungUmsetzungWeiterbildung(int bewertungUmsetzungWeiterbildung) {
    this.bewertungUmsetzungWeiterbildung = bewertungUmsetzungWeiterbildung;
  }

  public int getBewertungPraxisnaehe() {
    return bewertungPraxisnaehe;
  }

  public void setBewertungPraxisnaehe(int bewertungPraxisnaehe) {
    this.bewertungPraxisnaehe = bewertungPraxisnaehe;
  }

  public int getBewertungLehrveranstaltungen() {
    return bewertungLehrveranstaltungen;
  }

  public void setBewertungLehrveranstaltungen(int bewertungLehrveranstaltungen) {
    this.bewertungLehrveranstaltungen = bewertungLehrveranstaltungen;
  }

  public int getBewertungDozenten() {
    return bewertungDozenten;
  }

  public void setBewertungDozenten(int bewertungDozenten) {
    this.bewertungDozenten = bewertungDozenten;
  }

  public int getBewertungOrganisation() {
    return bewertungOrganisation;
  }

  public void setBewertungOrganisation(int bewertungOrganisation) {
    this.bewertungOrganisation = bewertungOrganisation;
  }

  public int getBewertungAusstattung() {
    return bewertungAusstattung;
  }

  public void setBewertungAusstattung(int bewertungAusstattung) {
    this.bewertungAusstattung = bewertungAusstattung;
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
