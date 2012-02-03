-- PostgreSQL 9 SQL

-- Sequence: employee_id_seq

-- DROP SEQUENCE employee_id_seq;

CREATE SEQUENCE employee_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE employee_id_seq OWNER TO postgres;

-- Table: employee

-- DROP TABLE employee;

CREATE TABLE employee
(
  id bigserial NOT NULL,
  surname character varying(100),
  givenname character varying(100),
  ssn character(10),
  century character(2),
  CONSTRAINT employee_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE employee OWNER TO postgres;
ALTER TABLE employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);