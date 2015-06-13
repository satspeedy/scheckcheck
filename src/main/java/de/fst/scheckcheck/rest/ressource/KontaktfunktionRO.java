package de.fst.scheckcheck.rest.ressource;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Ressourcen Objekt für {@link de.fst.scheckcheck.entitaet.Bewertung}.
 */
@XmlRootElement
public class KontaktfunktionRO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long empfaengerId;

  private String betreff;

  private String nachricht;

  public KontaktfunktionRO() {
  }

  public Long getEmpfaengerId() {
    return empfaengerId;
  }

  public void setEmpfaengerId(Long empfaengerId) {
    this.empfaengerId = empfaengerId;
  }

  public String getBetreff() {
    return betreff;
  }

  public void setBetreff(String betreff) {
    this.betreff = betreff;
  }

  public String getNachricht() {
    return nachricht;
  }

  public void setNachricht(String nachricht) {
    this.nachricht = nachricht;
  }
}
