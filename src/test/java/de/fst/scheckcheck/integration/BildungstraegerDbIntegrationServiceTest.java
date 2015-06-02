package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.allgemein.TestRessourcenProduzent;
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

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugeBildungstraeger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(TestRessourcenProduzent.class)
public class BildungstraegerDbIntegrationServiceTest {

  @Inject
  private BildungstraegerDbIntegrationsService bildungstraegerDbIntegrationsService;

  private EntityManagerFactory emf;

  private EntityManager em;

  private EntityTransaction et;

  @Before
  public void setUp() {
    this.em = bildungstraegerDbIntegrationsService.getEm();
    this.emf = this.em.getEntityManagerFactory();
    this.et = this.em.getTransaction();
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
    bildungstraegerDbIntegrationsService.setEm(this.em);
    this.et =  this.em.getTransaction();
  }

  @Test
  public void shouldSave() {
    this.et.begin();

    Bildungstraeger entity =  erzeugeBildungstraeger();
    entity = bildungstraegerDbIntegrationsService.speicher(entity);
    assertThat(entity.getId(), equalTo(1L));

    entity =  erzeugeBildungstraeger();
    entity = bildungstraegerDbIntegrationsService.speicher(entity);
    assertThat(entity.getId(), equalTo(2L));

    entity =  erzeugeBildungstraeger();
    entity = bildungstraegerDbIntegrationsService.speicher(entity);
    assertThat(entity.getId(), equalTo(3L));

    this.et.commit();
    this.refreshEntityManager();

    List<Bildungstraeger> bildungstraegers = bildungstraegerDbIntegrationsService.listeAlleAuf();
    assertThat(bildungstraegers, contains(hasProperty("id", is(1L)), hasProperty("id", is(2L)), hasProperty("id", is(3L))));
  }

  @Test
  public void shouldUpdate() {
    this.et.begin();
    Bildungstraeger entity =  erzeugeBildungstraeger();
    entity = bildungstraegerDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bildungstraegerDbIntegrationsService.suche(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getOptimisticLockingVersion(), equalTo(0L));
    String updateName = "testNeuerName";
    entity.setName(updateName);

    this.et.begin();
    bildungstraegerDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bildungstraegerDbIntegrationsService.suche(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getName(), equalTo(updateName));
    assertThat(entity.getOptimisticLockingVersion(), equalTo(1L));
  }

  @Test
  public void shouldDelete() {
    this.et.begin();
    Bildungstraeger entity =  erzeugeBildungstraeger();
    entity = bildungstraegerDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    this.et.begin();
    entity =  bildungstraegerDbIntegrationsService.suche(entity.getId());
    bildungstraegerDbIntegrationsService.loesche(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = bildungstraegerDbIntegrationsService.suche(entity.getId());
    assertThat(entity, nullValue());
  }

}