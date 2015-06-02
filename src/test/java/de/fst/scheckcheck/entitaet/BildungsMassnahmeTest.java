package de.fst.scheckcheck.entitaet;

import de.fst.scheckcheck.allgemein.TestRessourcenProduzent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugeBildungsmassnahme;
import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugeBildungstraeger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class BildungsmassnahmeTest {

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

    Bildungstraeger bildungstraeger = this.em.merge(erzeugeBildungstraeger());

    this.em.getTransaction().commit();
    this.refreshEntityManager();
    this.em.getTransaction().begin();

    Bildungsmassnahme bildungsmassnahme = erzeugeBildungsmassnahme();
    bildungsmassnahme.setBildungstraeger(bildungstraeger);
    this.em.merge(bildungsmassnahme);

    this.em.getTransaction().commit();
    this.refreshEntityManager();

    Bildungsmassnahme result = this.em.createNamedQuery(Bildungsmassnahme.NQ_FINDE_ALLE, Bildungsmassnahme.class).getSingleResult();
    assertThat(result, notNullValue());
    assertThat(result.getId(), notNullValue());
  }
}