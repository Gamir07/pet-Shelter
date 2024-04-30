-- liquibase formatted sql

-- changeset ggainullin:1

create table dogshelter(
	id bigserial primary key,
	information varchar(256),
	address varchar(50),
	file_path_to_road_map varchar(50)
);