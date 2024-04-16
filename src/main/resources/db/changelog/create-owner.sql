-- liquibase formatted sql

-- changeset ggainullin:1

create table owner(
	chat_id bigserial  primary key,
	name varchar(50),
	phone_number varchar(12),
	is_volunteer boolean,
	date_of_adoption date,
	pet_id bigserial references Pet (id)
);