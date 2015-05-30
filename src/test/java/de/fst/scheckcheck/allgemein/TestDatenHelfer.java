package de.fst.scheckcheck.allgemein;

import de.fst.scheckcheck.entitaet.*;
import de.fst.scheckcheck.rest.ressource.BasisRO;
import de.fst.scheckcheck.rest.ressource.TeilnehmerRO;

import java.util.Date;
import java.util.Random;
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

  public static Bewertung erzeugeBewertung() {
    Bewertung bewertung = new Bewertung();
    bewertung.setDatum(new Date());
    bewertung.setSternebewertung("5");
    bewertung.setFreiText("Freitext");
    return bewertung;
  }

  public static BildungsMassnahme erzeugeBildungsMassnahme() {
    BildungsMassnahme bildungsMassnahme = new BildungsMassnahme();
    bildungsMassnahme.setName("IT-Grundkurs");
    bildungsMassnahme.setOrt("Dortmund");
    bildungsMassnahme.setBeschreibung("In diesem Kurs werden grundlegende IT-Kenntnisse erlernt.");
    return bildungsMassnahme;
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

  public static PortalMitarbeiter erzeugePortalMitarbeiter() {
    PortalMitarbeiter PortalMitarbeiter = new PortalMitarbeiter();
    PortalMitarbeiter.setPasswort("passwort");
    PortalMitarbeiter.setUsername("username" + UUID.randomUUID());
    PortalMitarbeiter.setAdministrationsRolle(true);
    return PortalMitarbeiter;
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

  public static BasisRO setzeROIdUndVersion(BasisRO ro) {
    ro.setId(new Random().nextLong());
    ro.setOptimisticLockingVersion(0L);
    return ro;
  }
}
