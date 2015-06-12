package de.fst.scheckcheck.rest.ressource.full;

import de.fst.scheckcheck.rest.ressource.BasisRO;
import de.fst.scheckcheck.rest.ressource.BildungsmassnahmeRO;
import de.fst.scheckcheck.rest.ressource.TeilnehmerRO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Bewertung}.
 */
@XmlRootElement
public class BewertungFullRO implements BasisRO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long optimisticLockingVersion;

  private Date datum;

  private int bewertungInhaltWeiterbildung;

  private int bewertungUmsetzungWeiterbildung;

  private int bewertungPraxisnaehe;

  private int bewertungLehrveranstaltungen;

  private int bewertungDozenten;

  private int bewertungOrganisation;

  private int bewertungAusstattung;

  private int bewertungDurchschnitt;

  private String freiText;

  private TeilnehmerRO teilnehmer;

  private BildungsmassnahmeRO bildungsmassnahme;

  public BewertungFullRO() {
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

  public TeilnehmerRO getTeilnehmer() {
    return teilnehmer;
  }

  public void setTeilnehmer(TeilnehmerRO teilnehmer) {
    this.teilnehmer = teilnehmer;
  }

  public BildungsmassnahmeRO getBildungsmassnahme() {
    return bildungsmassnahme;
  }

  public void setBildungsmassnahme(BildungsmassnahmeRO bildungsmassnahme) {
    this.bildungsmassnahme = bildungsmassnahme;
  }

  public int getBewertungDurchschnitt() {
    return bewertungDurchschnitt;
  }

  public void setBewertungDurchschnitt(int bewertungDurchschnitt) {
    this.bewertungDurchschnitt = bewertungDurchschnitt;
  }
}
