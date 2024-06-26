-- liquibase formatted sql

-- changeset ggainullin:1

create table pet(
	id bigserial primary key,
	pet_type varchar(3),
	name varchar(50),
	is_handicapped boolean,
	is_adopted boolean,
	pet_photo oid,
	shelter_id bigserial references Shelter (id)
);