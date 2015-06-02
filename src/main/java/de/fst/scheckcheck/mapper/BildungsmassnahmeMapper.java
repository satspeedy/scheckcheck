package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.rest.ressource.BildungsmassnahmeRO;

import javax.persistence.OptimisticLockException;

/**
 * Mapper für Entität Bildungsmassnahme.
 */
public class BildungsmassnahmeMapper {

  private KonfigurierterMapper mapper = new KonfigurierterMapper();

  /**
   * Mapped von Entität nach Resource object.
   *
   * @param ro Resource object
   * @param entity entitaet
   * @return Resource object
   */
  public BildungsmassnahmeRO vonEntitaet(BildungsmassnahmeRO ro, Bildungsmassnahme entity) {
    if (ro == null) {
      ro = new BildungsmassnahmeRO();
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
  public Bildungsmassnahme vonRO(Bildungsmassnahme entity, BildungsmassnahmeRO ro) {
    if (entity == null) {
      entity = new Bildungsmassnahme();
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
