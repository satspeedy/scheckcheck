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
    assertThat(ro.getBewertungInhaltWeiterbildung(), notNullValue());
    assertThat(ro.getBewertungInhaltWeiterbildung(), equalTo(entitaet.getBewertungInhaltWeiterbildung()));
    assertThat(ro.getBewertungUmsetzungWeiterbildung(), notNullValue());
    assertThat(ro.getBewertungUmsetzungWeiterbildung(), equalTo(entitaet.getBewertungUmsetzungWeiterbildung()));
    assertThat(ro.getBewertungPraxisnaehe(), notNullValue());
    assertThat(ro.getBewertungPraxisnaehe(), equalTo(entitaet.getBewertungPraxisnaehe()));
    assertThat(ro.getBewertungLehrveranstaltungen(), notNullValue());
    assertThat(ro.getBewertungLehrveranstaltungen(), equalTo(entitaet.getBewertungLehrveranstaltungen()));
    assertThat(ro.getBewertungDozenten(), notNullValue());
    assertThat(ro.getBewertungDozenten(), equalTo(entitaet.getBewertungDozenten()));
    assertThat(ro.getBewertungOrganisation(), notNullValue());
    assertThat(ro.getBewertungOrganisation(), equalTo(entitaet.getBewertungOrganisation()));
    assertThat(ro.getBewertungAusstattung(), notNullValue());
    assertThat(ro.getBewertungAusstattung(), equalTo(entitaet.getBewertungAusstattung()));
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
    assertThat(entitaet.getBewertungInhaltWeiterbildung(), notNullValue());
    assertThat(entitaet.getBewertungInhaltWeiterbildung(), equalTo(ro.getBewertungInhaltWeiterbildung()));
    assertThat(entitaet.getBewertungUmsetzungWeiterbildung(), notNullValue());
    assertThat(entitaet.getBewertungUmsetzungWeiterbildung(), equalTo(ro.getBewertungUmsetzungWeiterbildung()));
    assertThat(entitaet.getBewertungPraxisnaehe(), notNullValue());
    assertThat(entitaet.getBewertungPraxisnaehe(), equalTo(ro.getBewertungPraxisnaehe()));
    assertThat(entitaet.getBewertungLehrveranstaltungen(), notNullValue());
    assertThat(entitaet.getBewertungLehrveranstaltungen(), equalTo(ro.getBewertungLehrveranstaltungen()));
    assertThat(entitaet.getBewertungDozenten(), notNullValue());
    assertThat(entitaet.getBewertungDozenten(), equalTo(ro.getBewertungDozenten()));
    assertThat(entitaet.getBewertungOrganisation(), notNullValue());
    assertThat(entitaet.getBewertungOrganisation(), equalTo(ro.getBewertungOrganisation()));
    assertThat(entitaet.getBewertungAusstattung(), notNullValue());
    assertThat(entitaet.getBewertungAusstattung(), equalTo(ro.getBewertungAusstattung()));
    assertThat(entitaet.getFreiText(), notNullValue());
    assertThat(entitaet.getFreiText(), equalTo(ro.getFreiText()));
    assertThat(entitaet.getTeilnehmer(), equalTo(ro.getTeilnehmer()));
    assertThat(entitaet.getTeilnehmer(), nullValue());
    assertThat(entitaet.getBildungsmassnahme(), nullValue());
    assertThat(entitaet.getBildungsmassnahme(), equalTo(ro.getBildungsmassnahme()));
  }

}
