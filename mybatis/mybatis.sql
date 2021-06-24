create table member4 (
	id varchar2(20) primary key,
	email varchar2(30),
	password varchar2(30),
	name varchar2(30),
	fileName varchar2(50),
	del char(1) default 'n',
	regdate date
);

-- 하나의 아이디에 사진을 여러 개 저장하는 table 생성
create table memberPhoto (
	num number(10) primary key,
	id varchar2(20) references member4(id),
	fileName varchar2(50)
);

-- memberPhoto의 primary key에 자동으로 1증가
create sequence memberPhoto_seq;

select * from member4;
select * from memberPhoto;

-- function 또는 procedure는 sqldeveloper에서 실행
create or replace function get_seq
	return number
is
begin
		return memberPhoto_seq.nextval;
end;
/