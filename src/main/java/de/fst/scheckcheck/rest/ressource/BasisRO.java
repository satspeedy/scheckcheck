package de.fst.scheckcheck.rest.ressource;

import java.io.Serializable;

/**
 * BasisRO Interface für alle Ressourcen Objekte mit einer id und version.
 */
public interface BasisRO extends Serializable {

  /**
   * Gibt id zurück.
   *
   * @return id
   */
  Long getId();

  /**
   * Setzt id.
   *
   * @param id id
   */
  void setId(Long id);

  /**
   * Gibt Version zurück.
   *
   * @return version
   */
  Long getOptimisticLockingVersion();

  /**
   * Setzt version.
   *
   * @param optimisticLockingVersion version
   */
  void setOptimisticLockingVersion(Long optimisticLockingVersion);

}
