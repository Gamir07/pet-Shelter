-- liquibase formatted sql

-- changeset ggainullin:1

create table petReport(
	id bigserial primary key,
	daily_photo_report oid,
	diet varchar(50),
	wellbeing varchar(50),
	behavior_changes varchar(50),
	file_path varchar(50),
	media_type varchar(50),
	file_size bigserial,
	date_of_report date,
	is_checked boolean,
	pet_id bigserial references Pet (id)
);