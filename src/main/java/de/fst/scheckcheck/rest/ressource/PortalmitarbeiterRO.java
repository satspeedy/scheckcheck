package de.fst.scheckcheck.rest.ressource;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Portalmitarbeiter}.
 */
@XmlRootElement
public class PortalmitarbeiterRO implements BasisRO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long optimisticLockingVersion;

  private String emailAddresse;

  private Boolean administrationsRolle;

  public PortalmitarbeiterRO() {
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

  public Boolean getAdministrationsRolle() {
    return administrationsRolle;
  }

  public void setAdministrationsRolle(Boolean administrationsRolle) {
    this.administrationsRolle = administrationsRolle;
  }

  public String getEmailAddresse() {
    return emailAddresse;
  }

  public void setEmailAddresse(String emailAddresse) {
    this.emailAddresse = emailAddresse;
  }
}
