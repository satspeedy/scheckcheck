package de.fst.scheckcheck.entitaet;

import de.fst.scheckcheck.allgemein.TestRessourcenProduzent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugeTeilnehmer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class TeilnehmerTest {

  private EntityManager em;

  private EntityManagerFactory emf;

  @Before
  public void setUp() {
    this.emf = Persistence.createEntityManagerFactory(TestRessourcenProduzent.PERSISTENZ_EINHEIT_NAME_FUER_TESTS);
    this.em = this.emf.createEntityManager();
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
  }

  @Test
  public void shouldSaveAndFind() {
    this.em.getTransaction().begin();
    this.em.merge(erzeugeTeilnehmer());
    this.em.getTransaction().commit();

    this.refreshEntityManager();

    Teilnehmer teilnehmer = this.em.createNamedQuery(Teilnehmer.NQ_FINDE_ALLE, Teilnehmer.class).getSingleResult();
    assertThat(teilnehmer, notNullValue());
    assertThat(teilnehmer.getId(), notNullValue());
  }
}