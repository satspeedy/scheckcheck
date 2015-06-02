    SET FOREIGN_KEY_CHECKS = 0;

    -- ------------------------------------------------------------------
    -- --------REPLACE CODE BELOW----------------------------------------
    -- ------------------------------------------------------------------

    alter table BEWERTUNG
        drop
        foreign key FK_he1koxjonyija9pbvsqo1gdk;

    alter table BEWERTUNG
        drop
        foreign key FK_562abuy89xslar5t1mtxp4oye;

    alter table BILDUNGSMASSNAHME
        drop
        foreign key FK_i4h3x64n0d27dpf7c343jyx07;

    drop table if exists BEWERTUNG;

    drop table if exists BILDUNGSMASSNAHME;

    drop table if exists BILDUNGSTRAEGER;

    drop table if exists PORTALMITARBEITER;

    drop table if exists TEILNEHMER;

    create table BEWERTUNG (
        id bigint not null auto_increment,
        optimisticLockingVersion bigint not null,
        datum datetime,
        frei_text varchar(255),
        sternebewertung varchar(255),
        bildungsmassnahme_id bigint not null,
        teilnehmer_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table BILDUNGSMASSNAHME (
        id bigint not null auto_increment,
        optimisticLockingVersion bigint not null,
        beschreibung varchar(255),
        name varchar(255),
        ort varchar(255),
        bildungstraeger_id bigint not null,
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

    create table PORTALMITARBEITER (
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

    alter table PORTALMITARBEITER
        add constraint UK_bkyvbsliogxfug4kfiy3f4jk6  unique (username);

    alter table TEILNEHMER
        add constraint UK_ioqfx7fsnw31lelxdgjd6bp55  unique (username);

    alter table BEWERTUNG
        add constraint FK_he1koxjonyija9pbvsqo1gdk
        foreign key (bildungsmassnahme_id)
        references BILDUNGSMASSNAHME (id);

    alter table BEWERTUNG
        add constraint FK_562abuy89xslar5t1mtxp4oye
        foreign key (teilnehmer_id)
        references TEILNEHMER (id);

    alter table BILDUNGSMASSNAHME
        add constraint FK_i4h3x64n0d27dpf7c343jyx07
        foreign key (bildungstraeger_id)
        references BILDUNGSTRAEGER (id);

    -- ------------------------------------------------------------------
    -- --------REPLACE CODE ABOVE----------------------------------------
    -- ------------------------------------------------------------------

    SET FOREIGN_KEY_CHECKS = 1;