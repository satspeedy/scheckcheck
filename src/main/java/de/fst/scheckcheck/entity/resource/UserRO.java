package de.fst.scheckcheck.entity.resource;

import de.fst.scheckcheck.entity.User;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Resource Object for {@link User}.
 */
@XmlRootElement
public class UserRO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private long version;

  private String username;

  private String password;

  public UserRO() {
  }

  public UserRO(User entity) {
    if (entity != null) {
      this.id = entity.getId();
      this.version = entity.getVersion();
      this.username = entity.getUsername();
      this.password = entity.getPassword();
    }
  }

  public User fromDTO(User entity, EntityManager em) {
    if (entity == null) {
      entity = new User();
    }
    entity.setId(this.id);
    entity.setVersion(this.version);
    entity.setUsername(this.username);
    entity.setPassword(this.password);
    entity = em.merge(entity);
    return entity;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(final long version) {
    this.version = version;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }
}