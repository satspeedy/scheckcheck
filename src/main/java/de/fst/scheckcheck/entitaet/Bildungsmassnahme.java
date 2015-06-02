package de.fst.scheckcheck.entitaet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entität Bildungsmaßnahme.
 */
@Entity
@Table(name = "BILDUNGSMASSNAHME")
@NamedQuery(name = Bildungsmassnahme.NQ_FINDE_ALLE, query = "SELECT b FROM Bildungsmassnahme b")
public class Bildungsmassnahme extends BasisEntitaet {

  public static final String NQ_FINDE_ALLE = "Bildungsmassnahme.findeAlle";

  private static final long serialVersionUID = 1L;

  private String name;

  private String ort;

  private String beschreibung;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bildungstraeger_id", nullable = false)
  private Bildungstraeger bildungstraeger;

  @OneToMany(mappedBy = "bildungsmassnahme", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private List<Bewertung> bewertungen = new ArrayList<>();

  public Bildungsmassnahme() {
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

  /**
   * Setzt Bildungstraeger.
   *
   * @param bildungstraeger bildungstraeger
   */
  public void setBildungstraeger(Bildungstraeger bildungstraeger) {
    this.bildungstraeger = bildungstraeger;
    if (bildungstraeger != null && !bildungstraeger.getBildungsmassnahmen().contains(this)) {
      bildungstraeger.getBildungsmassnahmen().add(this);
    }
  }

  public List<Bewertung> getBewertungen() {
    return bewertungen;
  }

  public void setBewertungen(List<Bewertung> bewertungen) {
    this.bewertungen = bewertungen;
  }

  /**
   * Fügt der Bildungsmassnahme eine Bewertung hinzu.
   *
   * @param bewertung Bewertung
   */
  public void fuegeBewertungHinzu(Bewertung bewertung) {
    if (bewertung != null) {
      this.bewertungen.add(bewertung);
      if (bewertung.getBildungsmassnahme() != this) {
        bewertung.setBildungsmassnahme(this);
      }
    }
  }

}
