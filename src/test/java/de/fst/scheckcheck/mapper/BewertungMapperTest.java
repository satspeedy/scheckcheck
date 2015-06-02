package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Bewertung;
import de.fst.scheckcheck.rest.ressource.BewertungRO;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(CdiRunner.class)
public class BewertungMapperTest {

  @Inject
  private BewertungMapper mapper;

  @Test
  public void shouldMapFromEntityToRO() {
    // given
    Bewertung entitaet = erzeugeBewertung();
    setzeEntitaetIdUndVersion(entitaet);
    // when
    BewertungRO ro = mapper.vonEntitaet(new BewertungRO(), entitaet);
    // then
    assertThat(ro.getId(), notNullValue());
    assertThat(ro.getId(), equalTo(entitaet.getId()));
    assertThat(ro.getOptimisticLockingVersion(), notNullValue());
    assertThat(ro.getOptimisticLockingVersion(), equalTo(entitaet.getOptimisticLockingVersion()));
    assertThat(ro.getDatum(), notNullValue());
    assertThat(ro.getDatum(), equalTo(entitaet.getDatum()));
    assertThat(ro.getSternebewertung(), notNullValue());
    assertThat(ro.getSternebewertung(), equalTo(entitaet.getSternebewertung()));
    assertThat(ro.getFreiText(), notNullValue());
    assertThat(ro.getFreiText(), equalTo(entitaet.getFreiText()));
    assertThat(ro.getTeilnehmer(), equalTo(entitaet.getTeilnehmer()));
    assertThat(ro.getTeilnehmer(), nullValue());
    assertThat(ro.getBildungsmassnahme(), nullValue());
    assertThat(ro.getBildungsmassnahme(), equalTo(entitaet.getBildungsmassnahme()));
  }

  @Test
  public void shouldMapFromROToEntity() {
    // given
    BewertungRO ro = erzeugeBewertungRO();
    setzeROIdUndVersion(ro);
    // when
    Bewertung entitaet = mapper.vonRO(new Bewertung(), ro);
    // then
    assertThat(entitaet.getId(), notNullValue());
    assertThat(entitaet.getId(), equalTo(ro.getId()));
    assertThat(entitaet.getOptimisticLockingVersion(), notNullValue());
    assertThat(entitaet.getOptimisticLockingVersion(), equalTo(ro.getOptimisticLockingVersion()));
    assertThat(entitaet.getDatum(),notNullValue());
    assertThat(entitaet.getDatum(), equalTo(ro.getDatum()));
    assertThat(entitaet.getSternebewertung(), notNullValue());
    assertThat(entitaet.getSternebewertung(), equalTo(ro.getSternebewertung()));
    assertThat(entitaet.getFreiText(), notNullValue());
    assertThat(entitaet.getFreiText(), equalTo(ro.getFreiText()));
    assertThat(entitaet.getTeilnehmer(), equalTo(ro.getTeilnehmer()));
    assertThat(entitaet.getTeilnehmer(), nullValue());
    assertThat(entitaet.getBildungsmassnahme(), nullValue());
    assertThat(entitaet.getBildungsmassnahme(), equalTo(ro.getBildungsmassnahme()));
  }

}
