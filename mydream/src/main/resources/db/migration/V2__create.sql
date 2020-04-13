create table userInfo (
	userid varchar(11),
	password varchar(255),
	lifeNumber integer,
	age integer,
	gender char(1),
	createDate Date
);

CREATE SEQUENCE seq_no START 1;

CREATE SEQUENCE seq_no2 START 1;

create table songInfo(
	num integer DEFAULT nextval('seq_no'),
	songname varchar(50),
	songartist  varchar(50),
    songlyrics varchar(3000),
    regDt date,
    clickcount integer DEFAULT 0
);

create table songword(
	num integer DEFAULT nextval('seq_no2'),
	songname varchar(50),
	englishword  varchar(50),
	koreaword  varchar(50),
    regDt date
);


