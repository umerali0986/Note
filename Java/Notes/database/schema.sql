create table if not exists notes(
id serial,
title varchar(255) not null,
note text,
is_favorite boolean,
constraint pk_notes primary key (id)
