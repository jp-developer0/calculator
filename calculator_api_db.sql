drop database calculatordb;
drop user calculator;
create user calculator with password 'password';
create database calculatordb with template=template0 owner=calculator;
\connect calculatordb;
alter default privileges grant all on tables to calculator;
alter default privileges grant all on sequences to calculator;

create table users(
user_id integer primary key not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(30) not null,
password text not null
);

create sequence users_seq increment 1 start 1;