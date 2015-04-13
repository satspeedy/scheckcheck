package de.fst.scheckcheck.entity.resource;

import de.fst.scheckcheck.entity.Member;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Resource Object for {@link Member}.
 */
@XmlRootElement
public class MemberRO extends UserRO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String surname;

  private Boolean newsletterFlag;

  private Boolean contactingFlag;

  public MemberRO() {
    super();
  }

  public MemberRO(Member entity) {
    super(entity);
    if (entity != null) {
      this.name = entity.getName();
      this.surname = entity.getSurname();
      this.newsletterFlag = entity.getNewsletterFlag();
      this.contactingFlag = entity.getContactingFlag();
    }
  }

  public Member fromDTO(Member entity, EntityManager em) {
    if (entity == null) {
      entity = new Member();
    }
    entity.setName(this.name);
    entity.setSurname(this.surname);
    entity.setNewsletterFlag(this.newsletterFlag);
    entity.setContactingFlag(this.contactingFlag);
    entity = em.merge(entity);
    return entity;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  public Boolean getNewsletterFlag() {
    return newsletterFlag;
  }

  public void setNewsletterFlag(final Boolean newsletterFlag) {
    this.newsletterFlag = newsletterFlag;
  }

  public Boolean getContactingFlag() {
    return contactingFlag;
  }

  public void setContactingFlag(final Boolean contactingFlag) {
    this.contactingFlag = contactingFlag;
  }

}