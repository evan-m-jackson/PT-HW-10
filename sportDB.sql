create database if not exists sports;

use sports;

drop tables if exists sports;

create table sports (
  sport_id int(10) not null auto_increment,
  name varchar(50) not null,
  primary key(sport_id)
);
