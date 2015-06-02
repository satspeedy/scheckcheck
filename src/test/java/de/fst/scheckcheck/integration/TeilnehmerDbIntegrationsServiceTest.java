package de.fst.scheckcheck.integration;

import de.fst.scheckcheck.allgemein.TestRessourcenProduzent;
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

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugeTeilnehmer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(TestRessourcenProduzent.class)
public class TeilnehmerDbIntegrationsServiceTest {

  @Inject
  private TeilnehmerDbIntegrationsService teilnehmerDbIntegrationsService;

  private EntityManagerFactory emf;

  private EntityManager em;

  private EntityTransaction et;

  @Before
  public void setUp() {
    this.em = teilnehmerDbIntegrationsService.getEm();
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
    teilnehmerDbIntegrationsService.setEm(this.em);
    this.et =  this.em.getTransaction();
  }

  @Test
  public void shouldSave() {
    this.et.begin();

    Teilnehmer entity = teilnehmerDbIntegrationsService.speicher(erzeugeTeilnehmer());
    assertThat(entity.getId(), equalTo(1L));

    entity = teilnehmerDbIntegrationsService.speicher(erzeugeTeilnehmer());
    assertThat(entity.getId(), equalTo(2L));

    entity = teilnehmerDbIntegrationsService.speicher(erzeugeTeilnehmer());
    assertThat(entity.getId(), equalTo(3L));

    this.et.commit();
    this.refreshEntityManager();

    List<Teilnehmer> teilnehmers = teilnehmerDbIntegrationsService.listeAlleAuf();
    assertThat(teilnehmers, contains(hasProperty("id", is(1L)), hasProperty("id", is(2L)), hasProperty("id", is(3L))));
  }

  @Test
  public void shouldUpdate() {
    this.et.begin();
    Teilnehmer entity = teilnehmerDbIntegrationsService.speicher(erzeugeTeilnehmer());
    this.et.commit();
    this.refreshEntityManager();

    entity = teilnehmerDbIntegrationsService.suche(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getOptimisticLockingVersion(), equalTo(0L));
    String updateName = "testname";
    entity.setVorname(updateName);

    this.et.begin();
    teilnehmerDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = teilnehmerDbIntegrationsService.suche(entity.getId());
    assertThat(entity, notNullValue());
    assertThat(entity.getVorname(), equalTo(updateName));
    assertThat(entity.getOptimisticLockingVersion(), equalTo(1L));
  }

  @Test
  public void shouldDelete() {
    this.et.begin();
    Teilnehmer entity = teilnehmerDbIntegrationsService.speicher(erzeugeTeilnehmer());
    this.et.commit();
    this.refreshEntityManager();

    this.et.begin();
    entity =  teilnehmerDbIntegrationsService.suche(entity.getId());
    teilnehmerDbIntegrationsService.loesche(entity);
    this.et.commit();
    this.refreshEntityManager();

    entity = teilnehmerDbIntegrationsService.suche(entity.getId());
    assertThat(entity, nullValue());
  }

  @Test
  public void shouldFindByUsername() {
    this.et.begin();
    Teilnehmer entity = erzeugeTeilnehmer();
    String username = "Test-Username";
    entity.setUsername(username);
    teilnehmerDbIntegrationsService.speicher(entity);
    this.et.commit();
    this.refreshEntityManager();

    Teilnehmer result =  teilnehmerDbIntegrationsService.sucheAnhandDesUsername(username);
    assertThat(result, notNullValue());
    assertThat(result.getUsername(), equalTo(username));
  }



}