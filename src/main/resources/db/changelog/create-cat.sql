-- liquibase formatted sql

-- changeset ggainullin:1

create table cat(
	id bigserial primary key,
	name varchar(50),
	is_handicapped boolean,
	is_adopted boolean,
	file_path_to_pet_photo varchar(50),
	shelter_id bigserial references Shelter (id)
);