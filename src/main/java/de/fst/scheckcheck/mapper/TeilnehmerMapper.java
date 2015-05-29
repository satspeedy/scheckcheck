package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Teilnehmer;
import de.fst.scheckcheck.rest.ressource.TeilnehmerRO;

import javax.persistence.OptimisticLockException;

/**
 * Mapper für Entität Teilnehmer.
 */
public class TeilnehmerMapper {

  /**
   * Mapped von Entität nach Resource object.
   *
   * @param ro Resource object
   * @param entity entitaet
   * @return Resource object
   */
  public TeilnehmerRO vonEntitaet(TeilnehmerRO ro, Teilnehmer entity) {
    if (ro == null) {
      ro = new TeilnehmerRO();
    }
    if (entity != null) {
      ro.setId(entity.getId());
      ro.setOptimisticLockingVersion(entity.getOptimisticLockingVersion());
      ro.setUsername(entity.getUsername());
      ro.setPasswort(entity.getPasswort());
      ro.setVorname(entity.getVorname());
      ro.setNachname(entity.getNachname());
      ro.setNewsletterKennzeichen(entity.getNewsletterKennzeichen());
      ro.setKontaktaufnahmeKennzeichen(entity.getKontaktaufnahmeKennzeichen());
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
  public Teilnehmer vonRO(Teilnehmer entity, TeilnehmerRO ro) {
    if (entity == null) {
      entity = new Teilnehmer();
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
      entity.setUsername(ro.getUsername());
      entity.setPasswort(ro.getPasswort());
      entity.setVorname(ro.getVorname());
      entity.setNachname(ro.getNachname());
      entity.setNewsletterKennzeichen(ro.getNewsletterKennzeichen());
      entity.setKontaktaufnahmeKennzeichen(ro.getKontaktaufnahmeKennzeichen());
    }
    return entity;
  }

}
