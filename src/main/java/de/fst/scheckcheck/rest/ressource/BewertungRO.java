package de.fst.scheckcheck.rest.ressource;

import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.entitaet.Teilnehmer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Bewertung}.
 */
@XmlRootElement
public class BewertungRO implements BasisRO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long optimisticLockingVersion;

  private Date datum;

  private String sternebewertung;

  private String freiText;

  private Teilnehmer teilnehmer;

  private Bildungsmassnahme bildungsmassnahme;

  public BewertungRO() {
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

  public void setTeilnehmer(Teilnehmer teilnehmer) {
    this.teilnehmer = teilnehmer;
  }

  public Bildungsmassnahme getBildungsmassnahme() {
    return bildungsmassnahme;
  }

  public void setBildungsmassnahme(Bildungsmassnahme bildungsmassnahme) {
    this.bildungsmassnahme = bildungsmassnahme;
  }

}
