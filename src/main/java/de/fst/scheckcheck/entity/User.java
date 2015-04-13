package de.fst.scheckcheck.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity implementation class for users.
 */
@Entity
@Table(name = "USERS")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = User.NQ_FIND_ALL, query = "SELECT u FROM User u")
public class User implements Serializable {

  public static final String NQ_FIND_ALL = "User.findAll";

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  @Version
  @Column(name = "db_version", nullable = false)
  private Long version;

  @Column(unique = true)
  private String username;

  private String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
