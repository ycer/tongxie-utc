-- only for postgreSQL

CREATE TABLE trainorder
(
  id bigserial NOT NULL,
  train_id character varying(24),
  train_type character varying(20),
  station_no integer ,
  station character(20),
  day integer ,
  a_time character(6),
  d_time character(6),
  distance integer ,
  p1 integer ,
  p2 integer ,
  p3 integer ,
  p4 integer ,
  CONSTRAINT trainorder_pk PRIMARY KEY (id)
);