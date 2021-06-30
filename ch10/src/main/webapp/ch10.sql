create table replyBoard (
	rno number primary key,
	bno number not null references board(num),
	replytext varchar2(500) not null,
	replyer varchar2(50) not null,
	regdate date not null,
	updatedate date not null,
	del char(1)
);

drop table replyBoard;

select * from board order by num desc;
insert into replyboard values(9,220,'비오나!','서장미',sysdate,sysdate,'n');
insert into replyboard values(8,226,'맑은데','고길동',sysdate,sysdate,'n');
select * from replyboard;

update board set del = 'n' where num = 241;