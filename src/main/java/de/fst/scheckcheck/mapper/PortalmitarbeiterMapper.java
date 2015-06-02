package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Portalmitarbeiter;
import de.fst.scheckcheck.rest.ressource.PortalmitarbeiterRO;

import javax.persistence.OptimisticLockException;

/**
 * Mapper für Entität Portalmitarbeiter.
 */
public class PortalmitarbeiterMapper {

  private KonfigurierterMapper mapper = new KonfigurierterMapper();

  /**
   * Mapped von Entität nach Resource object.
   *
   * @param ro Resource object
   * @param entity entitaet
   * @return Resource object
   */
  public PortalmitarbeiterRO vonEntitaet(PortalmitarbeiterRO ro, Portalmitarbeiter entity) {
    if (ro == null) {
      ro = new PortalmitarbeiterRO();
    }
    if (entity != null) {
      mapper.map(entity, ro);
    }
    return ro;
  }

  /**
   * Mapped von Resource object nach Entität.
   *
   * @param entity entitaet
   * @param ro Resource object
   * @return entitaet
   */
  public Portalmitarbeiter vonRO(Portalmitarbeiter entity, PortalmitarbeiterRO ro) {
    if (entity == null) {
      entity = new Portalmitarbeiter();
    }
    if (ro != null) {
      if (ro.getId() != null) {
        entity.setId(ro.getId());
      }
      if (ro.getOptimisticLockingVersion() != null && entity.getOptimisticLockingVersion() != null && ro.getOptimisticLockingVersion().compareTo(entity.getOptimisticLockingVersion()) != 0) {
        throw new OptimisticLockException("Resource object und Entitaet mit id " + ro.getId() + " sind nicht in der selben version!");
      }
      if (ro.getOptimisticLockingVersion() != null) {
        entity.setOptimisticLockingVersion(ro.getOptimisticLockingVersion());
      }
      mapper.map(ro, entity);
    }
    return entity;
  }

}
