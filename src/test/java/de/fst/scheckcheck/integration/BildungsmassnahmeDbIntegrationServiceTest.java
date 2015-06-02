package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.allgemein.TestRessourcenProduzent;
import de.fst.scheckcheck.entitaet.Bildungsmassnahme;
import de.fst.scheckcheck.entitaet.Bildungstraeger;
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

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugeBildungsmassnahme;
import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugeBildungstraeger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(TestRessourcenProduzent.class)
public class BildungsmassnahmeDbIntegrationServiceTest {

  @Inject
  private BildungsmassnahmeDbIntegrationsService bildungsmassnahmeDbIntegrationsService;

  private EntityManagerFactory emf;

  private EntityManager em;

  private EntityTransaction et;

  private Bildungstraeger bildungstraeger;

  @Before
  public void setUp() {
    this.em = bildungsmassnahmeDbIntegrationsService.getEm();
    this.emf = this.em.getEntityManagerFactory();
    this.et = this.em.getTransaction();

    // Aufbereitete Daten
    this.et.begin();
    this.bildungstraeger =  this.em.merge(erzeugeBildungstraeger());
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
    bildungsmassnahmeDbIntegrationsService.setEm(this.em);
    this.et =  this.em.getTransaction();
  }

  @Test
  public void shouldSave() {
    this.et.begin();

    Bildungsmassnahme entity =  erzeugeBildungsmassnahme();
    entity.setBildungstraeger(bildungstraeger);
    entity = bildungsmassnahmeDbIntegrationsService.speichern(entity);
    assertThat(entity.getId(), equalTo(1L));

    entity =  erzeugeBildungsmassnahme();
    entity.setBildungstraeger(bildungstraeger);
    entity = bildungsmassnahmeDbIntegrationsService.speichern(entity);
    assertThat(entity.getId(), equalTo(2L));

    entity =  erzeugeBildungsmassnahme();
    entity.setBildungstraeger(bildungstraeger);
    entity = bildungsmassnahmeDbIntegrationsService.speichern(entity);
    assertThat(entity.getId(), equalTo(3L));

    this.et.commit();
    this.refreshEntityManager();

    List<Bildungsmassnahme> bildungsmassnahmen = bildungsmassnahmeDbIntegrationsService.listeAlleAuf();
    assertThat(bildungsmassnahmen, contains(hasProperty("id", is(1L)), hasProperty("id", is(2L)), hasProperty("id", is(3L))));
  }

  @Test
  public void shouldUpdate() {
    this.et.begin();
    Bildungsmassnahme entity =  erzeugeBildungsmassnahme();
    entity.setBildungstraeger(bildungstraeger);
    entity = bildungsmassnahmeDbIntegrationsService.speichern(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bildungsmassnahmeDbIntegrationsService.suchen(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getOptimisticLockingVersion(), equalTo(0L));
    String updateName = "testNeuerName";
    entity.setName(updateName);

    this.et.begin();
    bildungsmassnahmeDbIntegrationsService.speichern(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bildungsmassnahmeDbIntegrationsService.suchen(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getName(), equalTo(updateName));
    assertThat(entity.getOptimisticLockingVersion(), equalTo(1L));
  }

  @Test
  public void shouldDelete() {
    this.et.begin();
    Bildungsmassnahme entity =  erzeugeBildungsmassnahme();
    entity.setBildungstraeger(bildungstraeger);
    entity = bildungsmassnahmeDbIntegrationsService.speichern(entity);
    this.et.commit();
    this.refreshEntityManager();

    this.et.begin();
    entity =  bildungsmassnahmeDbIntegrationsService.suchen(entity.getId());
    bildungsmassnahmeDbIntegrationsService.loeschen(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bildungsmassnahmeDbIntegrationsService.suchen(entity.getId());
    assertThat(entity, nullValue());
  }

}