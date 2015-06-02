package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Bewertung;
import de.fst.scheckcheck.rest.ressource.BewertungRO;

import javax.persistence.OptimisticLockException;

/**
 * Mapper für Entität Bewertung.
 */
public class BewertungMapper {

  private KonfigurierterMapper mapper = new KonfigurierterMapper();

  /**
   * Mapped von Entität nach Resource object.
   *
   * @param ro Resource object
   * @param entity entitaet
   * @return Resource object
   */
  public BewertungRO vonEntitaet(BewertungRO ro, Bewertung entity) {
    if (ro == null) {
      ro = new BewertungRO();
    }
    if (entity != null) {
      mapper.map(entity, ro);
//      ro.setId(entity.getId());
//      ro.setOptimisticLockingVersion(entity.getOptimisticLockingVersion());
//      ro.setDatum(entity.getDatum());
//      ro.setSternebewertung(entity.getSternebewertung());
//      ro.setFreiText(entity.getFreiText());
//      ro.setTeilnehmer(entity.getTeilnehmer());
//      ro.setBildungsmassnahme(entity.getBildungsmassnahme());
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
  public Bewertung vonRO(Bewertung entity, BewertungRO ro) {
    if (entity == null) {
      entity = new Bewertung();
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
//      entity.setDatum(ro.getDatum());
//      entity.setSternebewertung(ro.getSternebewertung());
//      entity.setFreiText(ro.getFreiText());
//      entity.setTeilnehmer(ro.getTeilnehmer());
//      entity.setBildungsmassnahme(ro.getBildungsmassnahme());
    }
    return entity;
  }

}
