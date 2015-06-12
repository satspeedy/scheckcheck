package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Bildungstraeger;
import de.fst.scheckcheck.rest.ressource.BildungstraegerRO;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(CdiRunner.class)
public class BildungstraegerMapperTest {

  @Inject
  private BildungstraegerMapper mapper;

  @Test
  public void shouldMapFromEntityToRO() {
    // given
    Bildungstraeger entitaet = erzeugeBildungstraeger();
    setzeEntitaetIdUndVersion(entitaet);
    // when
    BildungstraegerRO ro = mapper.vonEntitaet(new BildungstraegerRO(), entitaet);
    // then
    assertThat(ro.getId(), notNullValue());
    assertThat(ro.getId(), equalTo(entitaet.getId()));
    assertThat(ro.getOptimisticLockingVersion(), notNullValue());
    assertThat(ro.getOptimisticLockingVersion(), equalTo(entitaet.getOptimisticLockingVersion()));
    assertThat(ro.getName(), notNullValue());
    assertThat(ro.getName(), equalTo(entitaet.getName()));
    assertThat(ro.getOrt(), notNullValue());
    assertThat(ro.getOrt(), equalTo(entitaet.getOrt()));
    assertThat(ro.getKontaktdaten(), notNullValue());
    assertThat(ro.getKontaktdaten(), equalTo(entitaet.getKontaktdaten()));
    assertThat(ro.getBeschreibung(), notNullValue());
    assertThat(ro.getBeschreibung(), equalTo(entitaet.getBeschreibung()));
    assertThat(ro.getAngebot(), notNullValue());
    assertThat(ro.getAngebot(), equalTo(entitaet.getAngebot()));
//    assertThat(ro.getBildungsmassnahmen(), notNullValue());
//    assertThat(ro.getBildungsmassnahmen(), equalTo(entitaet.getBildungsmassnahmen()));
  }

  @Test
  public void shouldMapFromROToEntity() {
    // given
    BildungstraegerRO ro = erzeugeBildungstraegerRO();
    setzeROIdUndVersion(ro);
    // when
    Bildungstraeger entitaet = mapper.vonRO(new Bildungstraeger(), ro);
    // then
    assertThat(entitaet.getId(), notNullValue());
    assertThat(entitaet.getId(), equalTo(ro.getId()));
    assertThat(entitaet.getOptimisticLockingVersion(), notNullValue());
    assertThat(entitaet.getOptimisticLockingVersion(), equalTo(ro.getOptimisticLockingVersion()));
    assertThat(entitaet.getName(), notNullValue());
    assertThat(entitaet.getName(), equalTo(ro.getName()));
    assertThat(entitaet.getOrt(), notNullValue());
    assertThat(entitaet.getOrt(), equalTo(ro.getOrt()));
    assertThat(entitaet.getKontaktdaten(), notNullValue());
    assertThat(entitaet.getKontaktdaten(), equalTo(ro.getKontaktdaten()));
    assertThat(entitaet.getBeschreibung(), notNullValue());
    assertThat(entitaet.getBeschreibung(), equalTo(ro.getBeschreibung()));
    assertThat(entitaet.getAngebot(), notNullValue());
    assertThat(entitaet.getAngebot(), equalTo(ro.getAngebot()));
    assertThat(entitaet.getBildungsmassnahmen(), notNullValue());
//    assertThat(entitaet.getBildungsmassnahmen(), equalTo(ro.getBildungsmassnahmen()));
  }

}
