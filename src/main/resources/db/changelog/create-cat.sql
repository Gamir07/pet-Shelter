-- liquibase formatted sql

-- changeset ggainullin:1

create table cat(
	id bigserial primary key,
	name varchar(50),
	is_handicapped boolean,
	is_adopted boolean,
	pet_photo oid,
	shelter_id bigserial references Shelter (id)
);