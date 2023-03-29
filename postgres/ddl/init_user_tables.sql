CREATE SCHEMA IF NOT EXISTS fitness;

CREATE TABLE IF NOT EXISTS fitness.user_role (
    id smallserial,
    role character varying NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fitness.user_status (
    id smallserial,
    status character varying NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fitness.user (
    id uuid NOT NULL,
    dt_create timestamp with time zone NOT NULL,
    dt_update timestamp with time zone NOT NULL,
    mail character varying NOT NULL,
    fio character varying NOT NULL,
    role smallint NOT NULL,
    status smallint NOT NULL,
    password character varying NOT NULL,
    CONSTRAINT user_email UNIQUE (mail),
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_role_fkey FOREIGN KEY (role) REFERENCES fitness.user_role(id),
    CONSTRAINT user_status_fkey FOREIGN KEY (status) REFERENCES fitness.user_status(id)
);
