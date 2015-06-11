package de.fst.scheckcheck.mapper;

import de.fst.scheckcheck.entitaet.Teilnehmer;
import de.fst.scheckcheck.rest.ressource.TeilnehmerRO;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(CdiRunner.class)
public class TeilnehmerMapperTest {

  @Inject
  private TeilnehmerMapper mapper;

  @Test
  public void shouldMapFromEntityToRO() {
    // given
    Teilnehmer entitaet = erzeugeTeilnehmer();
    setzeEntitaetIdUndVersion(entitaet);
    // when
    TeilnehmerRO ro = mapper.vonEntitaet(new TeilnehmerRO(), entitaet);
    // then
    assertThat(ro.getId(), notNullValue());
    assertThat(ro.getId(), equalTo(entitaet.getId()));
    assertThat(ro.getOptimisticLockingVersion(), notNullValue());
    assertThat(ro.getOptimisticLockingVersion(), equalTo(entitaet.getOptimisticLockingVersion()));
    assertThat(ro.getPasswort(), notNullValue());
    assertThat(ro.getPasswort(), equalTo(entitaet.getPasswort()));
    assertThat(ro.getUsername(), notNullValue());
    assertThat(ro.getUsername(), equalTo(entitaet.getUsername()));
    assertThat(ro.getVorname(), notNullValue());
    assertThat(ro.getVorname(), equalTo(entitaet.getVorname()));
    assertThat(ro.getNachname(), notNullValue());
    assertThat(ro.getNachname(), equalTo(entitaet.getNachname()));
    assertThat(ro.getKontaktaufnahmeKennzeichen(), notNullValue());
    assertThat(ro.getKontaktaufnahmeKennzeichen(), equalTo(entitaet.getKontaktaufnahmeKennzeichen()));
    assertThat(ro.getNewsletterKennzeichen(), notNullValue());
    assertThat(ro.getNewsletterKennzeichen(), equalTo(entitaet.getNewsletterKennzeichen()));
    assertThat(ro.getBewertungen(), notNullValue());
    assertThat(ro.getBewertungen(), equalTo(entitaet.getBewertungen()));
    assertThat(ro.getEmailAddresse(), notNullValue());
    assertThat(ro.getEmailAddresse(), equalTo(entitaet.getEmailAddresse()));
  }

  @Test
  public void shouldMapFromROToEntity() {
    // given
    TeilnehmerRO ro = erzeugeTeilnehmerRO();
    setzeROIdUndVersion(ro);
    // when
    Teilnehmer entitaet = mapper.vonRO(new Teilnehmer(), ro);
    // then
    assertThat(entitaet.getId(), notNullValue());
    assertThat(entitaet.getId(), equalTo(ro.getId()));
    assertThat(entitaet.getOptimisticLockingVersion(), notNullValue());
    assertThat(entitaet.getOptimisticLockingVersion(), equalTo(ro.getOptimisticLockingVersion()));
    assertThat(entitaet.getPasswort(), notNullValue());
    assertThat(entitaet.getPasswort(), equalTo(ro.getPasswort()));
    assertThat(entitaet.getUsername(), notNullValue());
    assertThat(entitaet.getUsername(), equalTo(ro.getUsername()));
    assertThat(entitaet.getVorname(), notNullValue());
    assertThat(entitaet.getVorname(), equalTo(ro.getVorname()));
    assertThat(entitaet.getNachname(), notNullValue());
    assertThat(entitaet.getNachname(), equalTo(ro.getNachname()));
    assertThat(entitaet.getKontaktaufnahmeKennzeichen(), notNullValue());
    assertThat(entitaet.getKontaktaufnahmeKennzeichen(), equalTo(ro.getKontaktaufnahmeKennzeichen()));
    assertThat(entitaet.getNewsletterKennzeichen(), notNullValue());
    assertThat(entitaet.getNewsletterKennzeichen(), equalTo(ro.getNewsletterKennzeichen()));
    assertThat(entitaet.getBewertungen(), notNullValue());
    assertThat(entitaet.getBewertungen(), equalTo(ro.getBewertungen()));
    assertThat(entitaet.getEmailAddresse(), notNullValue());
    assertThat(entitaet.getEmailAddresse(), equalTo(ro.getEmailAddresse()));
  }

}
