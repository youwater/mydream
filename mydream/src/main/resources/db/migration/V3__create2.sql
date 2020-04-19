CREATE SEQUENCE seq_no3 START 1;

create table sayinginfo(
	num integer DEFAULT nextval('seq_no3'),
	engname varchar(50),
	job  varchar(50),
    engcontent varchar(1000),
    korcontent varchar(1000),
    regdt date,
    clickcount integer DEFAULT 0
);

CREATE SEQUENCE seq_no4 START 1;

create table engword(
	num integer DEFAULT nextval('seq_no4'),
	wordtype varchar(30),
	englishword  varchar(50),
	koreaword  varchar(100),
    regDt date
);