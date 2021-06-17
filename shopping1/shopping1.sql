create sequence item_seq start with 1 increment by 1

create table item(
	itemId number(5) ,
	itemName varchar2(20),
	price number(6),
	description varchar2(100),
	pictureUrl varchar2(20),
	primary key (itemId)
);

insert into item values(item_seq.nextval,'����',50,'�Ƿ�ȸ���� ���� ��Ÿ��C�� ǳ��','lemon.jpg');
insert into item values(item_seq.nextval,'������',100,'��Ÿ�� C�� ǳ���ϰ� ������ �ֽ��� ����.','orange.jpg');
insert into item values(item_seq.nextval,'Ű��',200,'��Ÿ�� C�� ǳ���Ͽ� ���̾�Ʈ�� �̿�','kiui.jpg');
insert into item values(item_seq.nextval,'����',300,'��������� �ٷ� �����ϰ��־� �׻�ȭ �ۿ�', 'ichigo.jpg');
insert into item values(item_seq.nextval,'����',800,'��Ÿ�� C�� �ö󺸳��̵带 �ٷ� ����', 'budou.jpg');
insert into item values(item_seq.nextval,'��',1000,'�ó��Ǹ��� �����ϰ� �־�� ����','mikan.jpg');

select * from item;