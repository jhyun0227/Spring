-- ȸ���Խ��ǿ����� �ۼ���(��� ȸ�� id�Ǵ� �̸�), ��ȣ, �̸���, ip�� �ʿ� ����
create table board (
	num number primary key, -- key ��ȣ
	writer varchar2(20) not null, -- �ۼ���
	subject varchar2(50) not null, -- ����
	content varchar2(500) not null, -- ����
	email varchar2(30) , -- �̸���
	readcount number default 0, -- ���� Ƚ��
	password varchar2(12) not null, -- ��ȣ
	ref number not null, -- �亯�۳��� �׷�
	re_step number not null, -- ref���� ����
	re_level number not null, -- �鿩����
	ip varchar2(20) not null, -- �ۼ��� ip
	reg_date date not null, -- �ۼ���
	del char(1) default 'n'
);