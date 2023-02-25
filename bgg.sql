select "Creating bgg database" as "";

drop database if exists bgg;

create database bgg;

use bgg;

create table game (
	gid int primary key auto_increment,
	name varchar(256) not null,
	year int not null,
	ranking int not null,
	users_rated int not null,
	url varchar(512),
	image varchar(512)
) auto_increment = 500000;

create table comment (
	c_id char(8) primary key,
	user varchar(64) not null,
	rating int,
	c_text text,
	gid int not null,

	constraint fk_gid foreign key (gid)
		references game(gid)
);