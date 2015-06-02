package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.allgemein.TestRessourcenProduzent;
import de.fst.scheckcheck.entitaet.Bewertung;
import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.entitaet.Bildungstraeger;
import de.fst.scheckcheck.entitaet.Teilnehmer;
import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(TestRessourcenProduzent.class)
public class BewertungDbIntegrationServiceTest {

  @Inject
  private BewertungDbIntegrationsService bewertungDbIntegrationsService;

  private EntityManagerFactory emf;

  private EntityManager em;

  private EntityTransaction et;

  private Teilnehmer teilnehmer;

  private Bildungstraeger bildungstraeger;

  private Bildungsmassnahme bildungsmassnahme;

  @Before
  public void setUp() {
    this.em = bewertungDbIntegrationsService.getEm();
    this.emf = this.em.getEntityManagerFactory();
    this.et = this.em.getTransaction();

    // Aufbereitete Daten
    this.et.begin();
    this.bildungstraeger =  this.em.merge(erzeugeBildungstraeger());
    this.bildungsmassnahme = erzeugeBildungsmassnahme();
    this.bildungsmassnahme.setBildungstraeger(bildungstraeger);
    this.bildungsmassnahme = this.em.merge(bildungsmassnahme);
    this.teilnehmer = this.em.merge(erzeugeTeilnehmer());
    this.et.commit();
    this.refreshEntityManager();
  }

  @After
  public void tearDown() {
    this.em.clear();
    this.em.close();
    this.emf.close();
  }

  public void refreshEntityManager() {
    this.em.clear();
    this.em.close();
    this.em = this.emf.createEntityManager();
    bewertungDbIntegrationsService.setEm(this.em);
    this.et =  this.em.getTransaction();
  }

  @Test
  public void shouldSave() {
    this.et.begin();

    Bewertung entity =  erzeugeBewertung();
    entity.setTeilnehmer(teilnehmer);
    entity.setBildungsmassnahme(bildungsmassnahme);
    entity = bewertungDbIntegrationsService.speicher(entity);
    assertThat(entity.getId(), equalTo(1L));

    entity =  erzeugeBewertung();
    entity.setTeilnehmer(teilnehmer);
    entity.setBildungsmassnahme(bildungsmassnahme);
    entity = bewertungDbIntegrationsService.speicher(entity);
    assertThat(entity.getId(), equalTo(2L));

    entity =  erzeugeBewertung();
    entity.setTeilnehmer(teilnehmer);
    entity.setBildungsmassnahme(bildungsmassnahme);
    entity = bewertungDbIntegrationsService.speicher(entity);
    assertThat(entity.getId(), equalTo(3L));

    this.et.commit();
    this.refreshEntityManager();

    List<Bewertung> bewertungen = bewertungDbIntegrationsService.listeAlleAuf();
    assertThat(bewertungen, contains(hasProperty("id", is(1L)), hasProperty("id", is(2L)), hasProperty("id", is(3L))));
  }

  @Test
  public void shouldUpdate() {
    this.et.begin();
    Bewertung entity =  erzeugeBewertung();
    entity.setTeilnehmer(teilnehmer);
    entity.setBildungsmassnahme(bildungsmassnahme);
    entity = bewertungDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bewertungDbIntegrationsService.suche(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getOptimisticLockingVersion(), equalTo(0L));
    String updateFreiText = "testFreiText";
    entity.setFreiText(updateFreiText);

    this.et.begin();
    bewertungDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bewertungDbIntegrationsService.suche(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getFreiText(), equalTo(updateFreiText));
    assertThat(entity.getOptimisticLockingVersion(), equalTo(1L));
  }

  @Test
  public void shouldDelete() {
    this.et.begin();
    Bewertung entity =  erzeugeBewertung();
    entity.setTeilnehmer(teilnehmer);
    entity.setBildungsmassnahme(bildungsmassnahme);
    entity = bewertungDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    this.et.begin();
    entity =  bewertungDbIntegrationsService.suche(entity.getId());
    bewertungDbIntegrationsService.loesche(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bewertungDbIntegrationsService.suche(entity.getId());
    assertThat(entity, nullValue());
  }

}