package de.fst.scheckcheck.allgemein;

import de.fst.scheckcheck.entitaet.*;
import de.fst.scheckcheck.rest.ressource.*;

import java.util.*;

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

  public static Bewertung erzeugeBewertung() {
    Bewertung bewertung = new Bewertung();
    bewertung.setDatum(new Date());
    bewertung.setSternebewertung("5");
    bewertung.setFreiText("Freitext");
    return bewertung;
  }

  public static Bildungsmassnahme erzeugeBildungsmassnahme() {
    Bildungsmassnahme bildungsmassnahme = new Bildungsmassnahme();
    bildungsmassnahme.setName("IT-Grundkurs");
    bildungsmassnahme.setOrt("Dortmund");
    bildungsmassnahme.setBeschreibung("In diesem Kurs werden grundlegende IT-Kenntnisse erlernt.");
    return bildungsmassnahme;
  }

  public static Bildungstraeger erzeugeBildungstraeger() {
    Bildungstraeger bildungstraeger = new Bildungstraeger();
    bildungstraeger.setName("IT-Grundkurs");
    bildungstraeger.setOrt("Dortmund");
    bildungstraeger.setKontaktdaten("Kontaktdaten");
    bildungstraeger.setBeschreibung("In diesem Kurs werden grundlegende IT-Kenntnisse erlernt.");
    bildungstraeger.setAngebot("ANgebot");
    return bildungstraeger;
  }

  public static Portalmitarbeiter erzeugePortalmitarbeiter() {
    Portalmitarbeiter Portalmitarbeiter = new Portalmitarbeiter();
    Portalmitarbeiter.setPasswort("passwort");
    Portalmitarbeiter.setUsername("username" + UUID.randomUUID());
    Portalmitarbeiter.setAdministrationsRolle(true);
    return Portalmitarbeiter;
  }

  public static BasisEntitaet setzeEntitaetIdUndVersion(BasisEntitaet entitaet) {
    entitaet.setId(new Random().nextLong());
    entitaet.setOptimisticLockingVersion(0L);
    return entitaet;
  }

  public static TeilnehmerRO erzeugeTeilnehmerRO() {
    TeilnehmerRO teilnehmerRO = new TeilnehmerRO();
    teilnehmerRO.setPasswort("passwort");
    teilnehmerRO.setUsername("username" + UUID.randomUUID());
    teilnehmerRO.setVorname("vorname");
    teilnehmerRO.setNachname("nachname");
    teilnehmerRO.setKontaktaufnahmeKennzeichen(true);
    teilnehmerRO.setNewsletterKennzeichen(true);
    return teilnehmerRO;
  }

  public static BewertungRO erzeugeBewertungRO() {
    BewertungRO bewertungRO = new BewertungRO();
    bewertungRO.setDatum(new Date());
    bewertungRO.setSternebewertung("5");
    bewertungRO.setFreiText("Freitext");
    return bewertungRO;
  }

  public static BildungsmassnahmeRO erzeugeBildungsmassnahmeRO() {
    BildungsmassnahmeRO bildungsmassnahmeRO = new BildungsmassnahmeRO();
    bildungsmassnahmeRO.setName("name");
    bildungsmassnahmeRO.setOrt("ort");
    bildungsmassnahmeRO.setBeschreibung("beschreibung");
    return bildungsmassnahmeRO;
  }

  public static BildungstraegerRO erzeugeBildungstraegerRO() {
    BildungstraegerRO bildungstraegerRO = new BildungstraegerRO();
    bildungstraegerRO.setName("name");
    bildungstraegerRO.setOrt("ort");
    bildungstraegerRO.setKontaktdaten("kontaktdaten");
    bildungstraegerRO.setBeschreibung("beschreibung");
    bildungstraegerRO.setAngebot("angebot");
    return bildungstraegerRO;
  }

  public static BasisRO setzeROIdUndVersion(BasisRO ro) {
    ro.setId(new Random().nextLong());
    ro.setOptimisticLockingVersion(0L);
    return ro;
  }
}
