-- liquibase formatted sql

-- changeset ggainullin:1

create table shelter(
	id bigserial primary key,
	information varchar(256),
	address varchar(50),
	road_map oid
);