create table if not exists users (
 username varchar(20) not null,
 password varchar(100) not null,
 enabled bit not null
);
create table if not exists authorities (
 username varchar(20) not null,
 authority varchar(20) not null
);