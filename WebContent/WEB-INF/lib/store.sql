DROP DATABASE IF EXISTS store;
CREATE DATABASE store DEFAULT CHARACTER SET utf8;

use store;
create table user_info(
	id int auto_increment primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	name varchar(50) not null,
	sex char(4) default null check (sex='ÄÐ' or sex='Å®' or sex=null),
	age int default null,
	address varchar(50) not null,
	phone varchar(15),
	unique(username)
)ENGINE=InnoDB auto_increment=1 default charset=utf8;

create table seller_info(
	id int auto_increment primary key,
	username varchar(50) not null unique,
	password varchar(50) not null,
	name varchar(50) not null,
	sex char(4) default null check(sex='ÄÐ' or sex='Å®' or sex=null),
	age int default null,
	address varchar(50) not null,
	phone varchar(15)
)ENGINE=InnoDB auto_increment=1 default charset=utf8;

create table commodity_info(
	id int auto_increment primary key,
	commodity_name varchar(50) not null,
	username varchar(50) not null,
	commodity_type int not null,
	datetime timestamp not null default current_timestamp,
	commodity_content varchar(8000) not null,
	commodity_money varchar(100) not null,
	img varchar(100) default 'https://www.zoomeye.org/static/media/zoomeye_v4.e3193c53.svg'
)ENGINE=InnoDB auto_increment=1 default charset=utf8;

create table commodity_comment(
	id int auto_increment primary key,
	username varchar(50) not null,
	commodity_id int not null,
	datetime timestamp not null default current_timestamp,
	content varchar(1000) not null
)ENGINE=InnoDB auto_increment=1 default charset=utf8;

create table commodity_type(
	commodity_type int auto_increment primary key,
	explains varchar(50)
)ENGINE=InnoDB auto_increment=1 default charset=utf8;

create table shopping(
	id int not null auto_increment primary key,
	username varchar(50) not null,
	commodity_id varchar(50) not null,
	content varchar(50) not null,
	datetime timestamp not null default current_timestamp
)ENGINE=InnoDB auto_increment=1 default charset=utf8;