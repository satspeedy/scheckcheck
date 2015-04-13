package de.fst.scheckcheck.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity implementation class for members.
 */
@Entity
@Table(name = "MEMBERS")
@NamedQuery(name = Member.NQ_FIND_ALL, query = "SELECT m FROM Member m")
public class Member extends User implements Serializable {

  public static final String NQ_FIND_ALL = "Member.findAll";

  private static final long serialVersionUID = 1L;

  private String name;

  private String surname;

  @Column(name = "newsletter_flag", precision = 1)
  private Boolean newsletterFlag;

  @Column(name = "contacting_flag", precision = 1)
  private Boolean contactingFlag;

  public Member() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Boolean getNewsletterFlag() {
    return newsletterFlag;
  }

  public void setNewsletterFlag(Boolean newsletterFlag) {
    this.newsletterFlag = newsletterFlag;
  }

  public Boolean getContactingFlag() {
    return contactingFlag;
  }

  public void setContactingFlag(Boolean contactingFlag) {
    this.contactingFlag = contactingFlag;
  }

}
