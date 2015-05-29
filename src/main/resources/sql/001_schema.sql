    SET FOREIGN_KEY_CHECKS = 0;

    -- ------------------------------------------------------------------
    -- --------REPLACE CODE BELOW----------------------------------------
    -- ------------------------------------------------------------------

    drop table if exists BEWERTUNG;

    drop table if exists BILDUNGSTRAEGER;

    drop table if exists BILDUNGS_MASSNAHME;

    drop table if exists PORTAL_MITARBEITER;

    drop table if exists TEILNEHMER;

    create table BEWERTUNG (
        id bigint not null auto_increment,
        optimisticLockingVersion bigint not null,
        datum datetime,
        frei_text varchar(255),
        sternebewertung varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table BILDUNGSTRAEGER (
        id bigint not null auto_increment,
        optimisticLockingVersion bigint not null,
        angebot varchar(255),
        beschreibung varchar(255),
        kontakt_daten varchar(255),
        name varchar(255),
        ort varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table BILDUNGS_MASSNAHME (
        id bigint not null auto_increment,
        optimisticLockingVersion bigint not null,
        beschreibung varchar(255),
        name varchar(255),
        ort varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table PORTAL_MITARBEITER (
        id bigint not null auto_increment,
        optimisticLockingVersion bigint not null,
        passwort varchar(255) not null,
        username varchar(255) not null,
        administrations_rolle bit,
        primary key (id)
    ) ENGINE=InnoDB;

    create table TEILNEHMER (
        id bigint not null auto_increment,
        optimisticLockingVersion bigint not null,
        passwort varchar(255) not null,
        username varchar(255) not null,
        kontaktaufnahme_kennzeichen bit,
        nachname varchar(255),
        newsletter_kennzeichen bit,
        vorname varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    alter table PORTAL_MITARBEITER
        add constraint UK_6i1t39jmlkm739it1ic9x3cvt  unique (username);

    alter table TEILNEHMER
        add constraint UK_ioqfx7fsnw31lelxdgjd6bp55  unique (username);

    -- ------------------------------------------------------------------
    -- --------REPLACE CODE ABOVE----------------------------------------
    -- ------------------------------------------------------------------

    SET FOREIGN_KEY_CHECKS = 1;