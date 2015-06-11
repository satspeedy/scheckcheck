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

  @Column(nullable = false)
  private String emailAddresse;

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

  public String getEmailAddresse() {
    return emailAddresse;
  }

  public void setEmailAddresse(String emailAddresse) {
    this.emailAddresse = emailAddresse;
  }
}
