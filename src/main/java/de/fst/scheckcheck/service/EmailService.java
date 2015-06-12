package de.fst.scheckcheck.service;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service zum einfachen senden von Emails.
 */
public class EmailService {

  private final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

  private static final String HOST = "localhost";
  private static final String FROM = "noreply@test.scheckcheck.com";
  private static final int PORT = 2525;

  /**
   * Email senden.
   *
   * @param emailAddresseEmpfaenger
   * @param betreff
   * @param nachricht
   */
  public void senden(String emailAddresseEmpfaenger, String betreff, String nachricht) {
    Email email = new SimpleEmail();
    email.setHostName(HOST);
    email.setSmtpPort(PORT);

    try {
      email.setFrom(FROM);
      email.setSubject(betreff);
      email.setMsg(nachricht);

      email.addTo(entferneNonInternationaleZeichenAusDerEmailAddresse(emailAddresseEmpfaenger));

      LOGGER.info("SENDIG EMAIL: " + email.toString());

      email.send();
    } catch (Exception ex) {
      LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
    }
  }

  private String entferneNonInternationaleZeichenAusDerEmailAddresse(String emailAddresse) {
    return emailAddresse.replaceAll("ß", "ss").replaceAll("ü", "ue").replaceAll(" ", "");
  }
}
