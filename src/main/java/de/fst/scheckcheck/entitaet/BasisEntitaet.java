package de.fst.scheckcheck.entitaet;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Abstrakte Entitätsklasse für alle Entitäten mit einer id und version.
 */
@MappedSuperclass
public abstract class BasisEntitaet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Version
  @Column(nullable = false)
  private Long optimisticLockingVersion;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOptimisticLockingVersion() {
    return optimisticLockingVersion;
  }

  public void setOptimisticLockingVersion(Long optimisticLockingVersion) {
    this.optimisticLockingVersion = optimisticLockingVersion;
  }

}
