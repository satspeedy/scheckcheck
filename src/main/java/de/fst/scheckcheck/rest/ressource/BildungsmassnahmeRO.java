package de.fst.scheckcheck.rest.ressource;

import de.fst.scheckcheck.entitaet.Bewertung;
import de.fst.scheckcheck.entitaet.Bildungstraeger;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Bildungsmassnahme}.
 */
@XmlRootElement
public class BildungsmassnahmeRO implements BasisRO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long optimisticLockingVersion;

  private String name;

  private String ort;

  private String beschreibung;

  private Bildungstraeger bildungstraeger;

  private List<Bewertung> bewertungen = new ArrayList<>();

  public BildungsmassnahmeRO() {
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

  public Bildungstraeger getBildungstraeger() {
    return bildungstraeger;
  }

  public void setBildungstraeger(Bildungstraeger bildungstraeger) {
    this.bildungstraeger = bildungstraeger;
  }

  public List<Bewertung> getBewertungen() {
    return bewertungen;
  }

  public void setBewertungen(List<Bewertung> bewertungen) {
    this.bewertungen = bewertungen;
  }
}
