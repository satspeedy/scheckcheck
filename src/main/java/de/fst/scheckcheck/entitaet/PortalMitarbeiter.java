package de.fst.scheckcheck.entitaet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entität Portalmitarbeiter.
 */
@Entity
@Table(name = "PORTALMITARBEITER")
@NamedQuery(name = Portalmitarbeiter.NQ_FINDE_ALLE, query = "SELECT p FROM Portalmitarbeiter p")
public class Portalmitarbeiter extends Nutzer {

  public static final String NQ_FINDE_ALLE = "Portalmitarbeiter.findeAlle";

  private static final long serialVersionUID = 1L;

  @Column(name = "administrations_rolle", precision = 1)
  private Boolean administrationsRolle;

  public Portalmitarbeiter() {
  }

  public Boolean getAdministrationsRolle() {
    return administrationsRolle;
  }

  public void setAdministrationsRolle(Boolean administrationsRolle) {
    this.administrationsRolle = administrationsRolle;
  }
}
