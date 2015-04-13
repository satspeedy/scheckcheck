    SET FOREIGN_KEY_CHECKS = 0;

    drop table if exists hibernate_sequences;

    -- ------------------------------------------------------------------
    -- --------REPLACE CODE BELOW----------------------------------------
    -- ------------------------------------------------------------------


    drop table if exists MEMBERS;

    drop table if exists USERS;

    create table MEMBERS (
        id bigint not null,
        password varchar(255),
        username varchar(255),
        db_version bigint not null,
        contacting_flag bit,
        name varchar(255),
        newsletter_flag bit,
        surname varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table USERS (
        id bigint not null,
        password varchar(255),
        username varchar(255),
        db_version bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    alter table MEMBERS
        add constraint UK_ldxhb88o8kuki2337ujtd4fq6  unique (username);

    alter table USERS
        add constraint UK_dc4eq7plr20fdhq528twsak1b  unique (username);

    -- ------------------------------------------------------------------
    -- --------REPLACE CODE ABOVE----------------------------------------
    -- ------------------------------------------------------------------

    CREATE TABLE hibernate_sequences (
      next_val bigint(20) DEFAULT NULL AUTO_INCREMENT,
      PRIMARY KEY (next_val)
    ) ENGINE=InnoDB;

    INSERT INTO hibernate_sequences (next_val) VALUES (1);

    SET FOREIGN_KEY_CHECKS = 1;