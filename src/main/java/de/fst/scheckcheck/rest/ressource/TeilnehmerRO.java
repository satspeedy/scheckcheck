package de.fst.scheckcheck.rest.ressource;

import de.fst.scheckcheck.entitaet.Bewertung;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Teilnehmer}.
 */
@XmlRootElement
public class TeilnehmerRO implements BasisRO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long optimisticLockingVersion;

  private String username;

  private String passwort;

  private String emailAddresse;

  private String vorname;

  private String nachname;

  private Boolean newsletterKennzeichen;

  private Boolean kontaktaufnahmeKennzeichen;

  private List<Bewertung> bewertungen = new ArrayList<>();

  public TeilnehmerRO() {
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public Long getOptimisticLockingVersion() {
    return optimisticLockingVersion;
  }

  @Override
  public void setOptimisticLockingVersion(Long optimisticLockingVersion) {
    this.optimisticLockingVersion = optimisticLockingVersion;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswort() {
    return passwort;
  }

  public void setPasswort(String passwort) {
    this.passwort = passwort;
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

  public String getEmailAddresse() {
    return emailAddresse;
  }

  public void setEmailAddresse(String emailAddresse) {
    this.emailAddresse = emailAddresse;
  }
}
