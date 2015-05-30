package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Teilnehmer;
import de.fst.scheckcheck.rest.ressource.TeilnehmerRO;
import org.junit.Before;
import org.junit.Test;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeilnehmerMapperTest {

  private TeilnehmerMapper teilnehmerMapper;

  @Before
  public void setUp() {
    this.teilnehmerMapper = new TeilnehmerMapper();
  }

  @Test
  public void shouldMapFromEntityToRO() {
    // given
    Teilnehmer entitaet = erzeugeTeilnehmer();
    setzeEntitaetIdUndVersion(entitaet);
    // when
    TeilnehmerRO ro = teilnehmerMapper.vonEntitaet(new TeilnehmerRO(), entitaet);
    // then
    assertThat(ro.getId(), equalTo(entitaet.getId()));
    assertThat(ro.getOptimisticLockingVersion(), equalTo(entitaet.getOptimisticLockingVersion()));
    assertThat(ro.getPasswort(), equalTo(entitaet.getPasswort()));
    assertThat(ro.getUsername(), equalTo(entitaet.getUsername()));
    assertThat(ro.getVorname(), equalTo(entitaet.getVorname()));
    assertThat(ro.getNachname(), equalTo(entitaet.getNachname()));
    assertThat(ro.getKontaktaufnahmeKennzeichen(), equalTo(entitaet.getKontaktaufnahmeKennzeichen()));
    assertThat(ro.getNewsletterKennzeichen(), equalTo(entitaet.getNewsletterKennzeichen()));
  }

  @Test
  public void shouldMapFromROToEntity() {
    // given
    TeilnehmerRO ro = erzeugeTeilnehmerRO();
    setzeROIdUndVersion(ro);
    // when
    Teilnehmer entitaet = teilnehmerMapper.vonRO(new Teilnehmer(), ro);
    // then
    assertThat(entitaet.getId(), equalTo(ro.getId()));
    assertThat(entitaet.getOptimisticLockingVersion(), equalTo(ro.getOptimisticLockingVersion()));
    assertThat(entitaet.getPasswort(), equalTo(ro.getPasswort()));
    assertThat(entitaet.getUsername(), equalTo(ro.getUsername()));
    assertThat(entitaet.getVorname(), equalTo(ro.getVorname()));
    assertThat(entitaet.getNachname(), equalTo(ro.getNachname()));
    assertThat(entitaet.getKontaktaufnahmeKennzeichen(), equalTo(ro.getKontaktaufnahmeKennzeichen()));
    assertThat(entitaet.getNewsletterKennzeichen(), equalTo(ro.getNewsletterKennzeichen()));
  }

}
