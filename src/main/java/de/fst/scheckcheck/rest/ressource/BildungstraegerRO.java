package de.fst.scheckcheck.rest.ressource;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Bildungstraeger}.
 */
@XmlRootElement
public class BildungstraegerRO implements BasisRO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long optimisticLockingVersion;

  private String name;

  private String ort;

  private String kontaktdaten;

  private String beschreibung;

  private String angebot;

  private List<Long> bildungsmassnahmeIds = new ArrayList<>();

  public BildungstraegerRO() {
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

  public List<Long> getBildungsmassnahmeIds() {
    return bildungsmassnahmeIds;
  }

  public void setBildungsmassnahmeIds(List<Long> bildungsmassnahmeIds) {
    this.bildungsmassnahmeIds = bildungsmassnahmeIds;
  }
}
