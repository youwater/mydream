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

create table engword(
	num integer,
	wordtype varchar(30),
	englishword  varchar(50),
	koreaword  varchar(100)
);

CREATE SEQUENCE seq_toeic START 1;
CREATE SEQUENCE seq_toeicanswer START 1;

create table toeicpart5(
	num integer DEFAULT nextval('seq_toeic'),
	content  varchar(2000),
    view1 varchar(1000),
    view2 varchar(1000),
    view3 varchar(1000),
	view4 varchar(1000)
);

create table toeicpart5answer(
	num integer DEFAULT nextval('seq_toeicanswer'),
	interpretation varchar(2000),
	explanation  varchar(2000),
	word varchar(1000),
	answer varchar(10)
);