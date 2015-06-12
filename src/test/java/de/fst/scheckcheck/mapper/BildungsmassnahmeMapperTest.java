package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.rest.ressource.BildungsmassnahmeRO;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(CdiRunner.class)
public class BildungsmassnahmeMapperTest {

  @Inject
  private BildungsmassnahmeMapper mapper;

  @Test
  public void shouldMapFromEntityToRO() {
    // given
    Bildungsmassnahme entitaet = erzeugeBildungsmassnahme();
    setzeEntitaetIdUndVersion(entitaet);
    // when
    BildungsmassnahmeRO ro = mapper.vonEntitaet(new BildungsmassnahmeRO(), entitaet);
    // then
    assertThat(ro.getId(), notNullValue());
    assertThat(ro.getId(), equalTo(entitaet.getId()));
    assertThat(ro.getOptimisticLockingVersion(), notNullValue());
    assertThat(ro.getOptimisticLockingVersion(), equalTo(entitaet.getOptimisticLockingVersion()));
    assertThat(ro.getName(), notNullValue());
    assertThat(ro.getName(), equalTo(entitaet.getName()));
    assertThat(ro.getOrt(), notNullValue());
    assertThat(ro.getOrt(), equalTo(entitaet.getOrt()));
    assertThat(ro.getBeschreibung(), notNullValue());
    assertThat(ro.getBeschreibung(), equalTo(entitaet.getBeschreibung()));
    assertThat(ro.getBildungstraegerId(), nullValue());
    assertThat(entitaet.getBildungstraeger(), nullValue());
    assertThat(ro.getBewertungIds(), notNullValue());
    assertThat(ro.getBewertungIds(), hasSize(0));
    assertThat(entitaet.getBewertungen(), hasSize(0));
  }

  @Test
  public void shouldMapFromROToEntity() {
    // given
    BildungsmassnahmeRO ro = erzeugeBildungsmassnahmeRO();
    setzeROIdUndVersion(ro);
    // when
    Bildungsmassnahme entitaet = mapper.vonRO(new Bildungsmassnahme(), ro);
    // then
    assertThat(entitaet.getId(), notNullValue());
    assertThat(entitaet.getId(), equalTo(ro.getId()));
    assertThat(entitaet.getOptimisticLockingVersion(), notNullValue());
    assertThat(entitaet.getOptimisticLockingVersion(), equalTo(ro.getOptimisticLockingVersion()));
    assertThat(entitaet.getName(), notNullValue());
    assertThat(entitaet.getName(), equalTo(ro.getName()));
    assertThat(entitaet.getOrt(), notNullValue());
    assertThat(entitaet.getOrt(), equalTo(ro.getOrt()));
    assertThat(entitaet.getBeschreibung(), notNullValue());
    assertThat(entitaet.getBeschreibung(), equalTo(ro.getBeschreibung()));
    assertThat(entitaet.getBildungstraeger(), nullValue());
    assertThat(ro.getBildungstraegerId(), nullValue());
    assertThat(entitaet.getBewertungen(), notNullValue());
    assertThat(entitaet.getBewertungen(), hasSize(0));
    assertThat(ro.getBewertungIds(), notNullValue());
    assertThat(ro.getBewertungIds(), hasSize(0));
  }

}
