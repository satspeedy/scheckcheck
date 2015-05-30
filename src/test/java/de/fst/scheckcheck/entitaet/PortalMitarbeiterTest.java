package de.fst.scheckcheck.entitaet;

import de.fst.scheckcheck.allgemein.TestRessourcenProduzent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static de.fst.scheckcheck.allgemein.TestDatenHelfer.erzeugePortalMitarbeiter;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class PortalMitarbeiterTest {

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
    this.em.merge(erzeugePortalMitarbeiter());
    this.em.getTransaction().commit();

    this.refreshEntityManager();

    PortalMitarbeiter portalMitarbeiter = this.em.createNamedQuery(PortalMitarbeiter.NQ_FINDE_ALLE, PortalMitarbeiter.class).getSingleResult();
    assertThat(portalMitarbeiter, notNullValue());
    assertThat(portalMitarbeiter.getId(), notNullValue());
  }
}