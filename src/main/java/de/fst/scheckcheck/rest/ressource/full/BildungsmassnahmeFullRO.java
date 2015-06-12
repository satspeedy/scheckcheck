package de.fst.scheckcheck.rest.ressource.full;

import de.fst.scheckcheck.rest.ressource.BasisRO;
import de.fst.scheckcheck.rest.ressource.BildungstraegerRO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Bildungsmassnahme} mit Bildungstraeger und Bewertungen.
 */
@XmlRootElement
public class BildungsmassnahmeFullRO implements BasisRO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long optimisticLockingVersion;

  private String name;

  private String ort;

  private String beschreibung;

  private BildungstraegerRO bildungstraeger;

  private List<BewertungFullRO> bewertungen = new ArrayList<>();

  public BildungsmassnahmeFullRO() {
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

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }

  public BildungstraegerRO getBildungstraeger() {
    return bildungstraeger;
  }

  public void setBildungstraeger(BildungstraegerRO bildungstraeger) {
    this.bildungstraeger = bildungstraeger;
  }

  public List<BewertungFullRO> getBewertungen() {
    return bewertungen;
  }

  public void setBewertungen(List<BewertungFullRO> bewertungen) {
    this.bewertungen = bewertungen;
  }
}
