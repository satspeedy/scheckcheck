package de.fst.scheckcheck.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class MemberTest {

  private EntityManager em;

  private EntityManagerFactory emf;

  @Before
  public void setUp() {
    this.emf = Persistence.createEntityManagerFactory("test-scheckcheck-PU");
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
  public void shouldSaveAndRead() {
    this.em.getTransaction().begin();
    this.em.merge(new Member());
    this.em.getTransaction().commit();

    this.refreshEntityManager();

    this.em.getTransaction().begin();
    Member member = this.em.createNamedQuery(Member.NQ_FIND_ALL, Member.class).getSingleResult();
    this.em.getTransaction().commit();

    this.refreshEntityManager();

    assertThat(member, notNullValue());
    assertThat(member.getId(), notNullValue());
  }
}