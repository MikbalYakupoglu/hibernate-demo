drop table persons;

create table if not exists persons (
    id bigint not null,
    name varchar(255),
    location varchar(255),
    birth_date timestamp,
    primary key (id)
);

insert into persons (id, name, location, birth_date) values (10001, 'Ranga', 'Hyderabad', CURRENT_TIMESTAMP());
insert into persons (id, name, location, birth_date) values (10002, 'James', 'New York', CURRENT_TIMESTAMP());
insert into persons (id, name, location, birth_date) values (10003, 'Pieter', 'Amsterdam', CURRENT_TIMESTAMP());
