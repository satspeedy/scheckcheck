package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.*;
import de.fst.scheckcheck.rest.ressource.*;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Mapper Konfiguration für Entiäten und Ressource objekten.
 */
public class KonfigurierterMapper extends ConfigurableMapper {

  @Override
  protected void configure(MapperFactory factory) {
    // register the auto-mapping function
    factory.registerClassMap(factory.classMap(Teilnehmer.class, TeilnehmerRO.class).byDefault().toClassMap());
    factory.registerClassMap(factory.classMap(Bewertung.class, BewertungRO.class).byDefault().toClassMap());
    factory.registerClassMap(factory.classMap(Bildungstraeger.class, BildungstraegerRO.class).byDefault().toClassMap());
    factory.registerClassMap(factory.classMap(Bildungsmassnahme.class, BildungsmassnahmeRO.class).byDefault().toClassMap());
    factory.registerClassMap(factory.classMap(Portalmitarbeiter.class, PortalmitarbeiterRO.class).byDefault().toClassMap());
  }
}
