create table userInfo (
	userid varchar(11),
	password varchar(255),
	lifeNumber integer,
	age integer,
	gender char(1),
	createDate Date
);

CREATE SEQUENCE seq_no START 1;

create table songInfo(
	num integer DEFAULT nextval('seq_no'),
	songname varchar(50),
	songartist  varchar(50),
    songlyrics varchar(3000),
    englishword varchar(1000)[],
    regDt date,
    songreleasedate date
);