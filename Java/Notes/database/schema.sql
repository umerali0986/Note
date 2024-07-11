create table if not exists notes(
id serial,
title varchar(255) not null,
note text,
constraint pk_notes primary key (id)
);

insert into notes (title, note) values
('Grocery', '1.banana 2.tomato 3. onion'),
('ToDo', '1.study 2.soccer');