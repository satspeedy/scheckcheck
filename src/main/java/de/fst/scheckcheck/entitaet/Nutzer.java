package de.fst.scheckcheck.entitaet;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Abstrakte Entitätsklasse Nutzer zum Erweitern der Sub Entitäten.
 */
@MappedSuperclass
public abstract class Nutzer extends BasisEntitaet {

  private static final long serialVersionUID = 1L;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String passwort;

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

}
