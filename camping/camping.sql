** tableList 
**memberTable
drop table member;
select * from member;
create table member (
	mId			varchar2(40),
 	password	varchar2(40),
 	mName		varchar2(40),
 	postcode	varchar2(20),
	address		varchar2(50),
 	email		varchar2(50),
 	job			varchar2(30),
 	PRIMARY KEY (mId)
);
-- ������
insert into member(mid,password) values('master','master');
update member set mName='�����' where mId='master';
select * from member where mid='master';
**product Table
select * from board;
drop table product cascade constraint;
create table product(
 	pId				number(5) primary key,
 	pName			varchar2(40),
 	price			number(10),
 	description 	varchar2(100),
 	picUrl			varchar2(40), 
 	rangeCode		number(5),
 	mdCode			number(5),
 	voteCode		number(5),
 	hit				number(5),
 	regdate			DATE,
 	quantity        number(5) -- ���
);
update product set quantity =100;
drop sequence pId_seq;
-- sequence�� �ڵ����� 1�� ����
create sequence pId_seq;
select * from product;	

-- **locTable -- �������� �ִ� ��ġ 
create table loc(
 	locCode		number(5),
 	locName		varchar2(40),
 	locUrl		varchar2(40),
 	PRIMARY KEY (locCode)
);	

INSERT INTO LOC VALUES(0,'�����','seoul.jpg');
INSERT INTO LOC VALUES(1,'��⵵','gg.jpg');
INSERT INTO LOC VALUES(2,'������','gang.jpg');
INSERT INTO LOC VALUES(3,'��û��','cc.jpg');
INSERT INTO LOC VALUES(4,'����','jr.jpg');
INSERT INTO LOC VALUES(5,'���','gs.jpg');
INSERT INTO LOC VALUES(6,'���ֵ�','jeju.jpg');
INSERT INTO LOC VALUES(100,'��ü','map.jpg');

select * from loc;

**campsite Table
drop table campsite;
create table campsite(
	sId			number(5),
 	sName		varchar2(40),
 	address		varchar2(50),
 	phone		varchar2(40),
 	home		varchar2(100),
 	picUrl		varchar2(100),
 	locCode		number(5),
 	reservation number(1),   -- 1 ����Ϸ�,0 ���డ��
 	PRIMARY KEY (sId),
 	FOREIGN KEY (locCode) REFERENCES loc (locCode) 
);

-- alter table campsite modify(home varchar2(200));
-- alter table campsite add (reservation number(1));
-- update campsite set reservation=0;
create sequence sId_seq; -- ķ���� Ű�� �ڵ����� 1�� ����
--start with 1 
--	increment by 1 	nocycle nocache;
drop sequence sId_seq;
select * from campsite;

**board Table
drop table board5;
-- bCode ��ü, �丮, ����, �ı�, �����Խ�
create table board5 ( 
	bId			number(5),
 	writer		varchar2(40),
 	title		varchar2(40),
 	content		varchar2(100),
 	regdate		DATE,
 	hit			number(5),
 	bCode 		varchar2(40),
 	PRIMARY KEY (bId)
 );
 select * from board5;
 -- �Խ��� ��ȣ�� �ڵ�����1�� ����
create sequence bId_seq; 
select * from board5 where bcode='free';

** shortboard Table
drop table shortboard;
-- ��� �Խ�
create table shortboard(
 	pId			number(5),
 	writer		varchar2(40),
 	sbId		number(5),
 	content		varchar2(100),
 	regdate 	DATE,
 	PRIMARY KEY (sbId),
 	FOREIGN KEY (pId) REFERENCES product (pId) 
);
drop sequence sbId_seq;
-- ��� �Խ� pk�� �ڵ�����1�� ����
create sequence sbId_seq;
select * from shortboard;


**sale Table
select * from sale;
drop table sale;
-- �Ǹ�
create table sale(
 	saleId		number(10) ,
 	mId			varchar2(40) REFERENCES member (mId) ,
 	updateTime	TIMESTAMP,
 	PRIMARY KEY (saleId, mId) -- �ΰ��� �÷��� ���ļ� �ϳ��� primary key	
);
select * from sale;
**saleline Table
delete from sale;
drop table saleline;
-- �� �Ǹ� ����
create table saleline(
	saleId		number(10),
 	salelineId	number(5),
 	pId			number(5),
 	quantity	number(1),
 	updateTime	TIMESTAMP,
 	PRIMARY KEY (saleId, salelineId), 
	FOREIGN KEY (pId) REFERENCES product (pId)
);
select * from saleline;
 