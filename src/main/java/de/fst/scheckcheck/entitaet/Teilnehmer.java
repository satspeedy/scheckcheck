package de.fst.scheckcheck.entitaet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entität Teilnehmer.
 */
@Entity
@Table(name = "TEILNEHMER")
@NamedQuery(name = Teilnehmer.NQ_FINDE_ALLE, query = "SELECT t FROM Teilnehmer t")
public class Teilnehmer extends Nutzer {

  public static final String NQ_FINDE_ALLE = "Teilnehmer.findeAlle";

  private static final long serialVersionUID = 1L;

  private String vorname;

  private String nachname;

  @Column(name = "newsletter_kennzeichen", precision = 1)
  private Boolean newsletterKennzeichen;

  @Column(name = "kontaktaufnahme_kennzeichen", precision = 1)
  private Boolean kontaktaufnahmeKennzeichen;

  @OneToMany(mappedBy = "teilnehmer", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private List<Bewertung> bewertungen = new ArrayList<>();

  public Teilnehmer() {
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getNachname() {
    return nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public Boolean getNewsletterKennzeichen() {
    return newsletterKennzeichen;
  }

  public void setNewsletterKennzeichen(Boolean newsletterKennzeichen) {
    this.newsletterKennzeichen = newsletterKennzeichen;
  }

  public Boolean getKontaktaufnahmeKennzeichen() {
    return kontaktaufnahmeKennzeichen;
  }

  public void setKontaktaufnahmeKennzeichen(Boolean kontaktaufnahmeKennzeichen) {
    this.kontaktaufnahmeKennzeichen = kontaktaufnahmeKennzeichen;
  }

  public List<Bewertung> getBewertungen() {
    return bewertungen;
  }

  public void setBewertungen(List<Bewertung> bewertungen) {
    this.bewertungen = bewertungen;
  }

}
