package de.fst.scheckcheck.domain.resource;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import de.fst.scheckcheck.domain.entity.Member;

@XmlRootElement
public class MemberRO implements Serializable {

  /**
   * Resource Object for {@link Member}.
   */
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;

  public MemberRO() {
  }

  public MemberRO(Member entity) {
    if (entity != null) {
      this.id = entity.getId();
      this.name = entity.getName();
    }
  }

  public Member fromDTO(Member entity, EntityManager em) {
    if (entity == null) {
      entity = new Member();
    }
    entity.setName(this.name);
    entity = em.merge(entity);
    return entity;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}