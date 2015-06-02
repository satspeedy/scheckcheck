package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Bildungstraeger;
import de.fst.scheckcheck.rest.ressource.BildungstraegerRO;

import javax.persistence.OptimisticLockException;

/**
 * Mapper für Entität Bildungstraeger.
 */
public class BildungstraegerMapper {

  private KonfigurierterMapper mapper = new KonfigurierterMapper();

  /**
   * Mapped von Entität nach Resource object.
   *
   * @param ro Resource object
   * @param entity entitaet
   * @return Resource object
   */
  public BildungstraegerRO vonEntitaet(BildungstraegerRO ro, Bildungstraeger entity) {
    if (ro == null) {
      ro = new BildungstraegerRO();
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
  public Bildungstraeger vonRO(Bildungstraeger entity, BildungstraegerRO ro) {
    if (entity == null) {
      entity = new Bildungstraeger();
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
