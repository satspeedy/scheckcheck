package de.fst.scheckcheck.allgemein;

import de.fst.scheckcheck.entitaet.Teilnehmer;

import java.util.UUID;

/**
 * Helfer Funktionen für Testdaten
 */
public class TestDatenHelfer {

  private TestDatenHelfer() {
  }

  public static Teilnehmer erzeugeTeilnehmer() {
    Teilnehmer teilnehmer = new Teilnehmer();
    teilnehmer.setPasswort("passwort");
    teilnehmer.setUsername("username" + UUID.randomUUID());
    teilnehmer.setVorname("vorname");
    teilnehmer.setNachname("nachname");
    teilnehmer.setKontaktaufnahmeKennzeichen(true);
    teilnehmer.setNewsletterKennzeichen(true);
    return teilnehmer;
  }
}
