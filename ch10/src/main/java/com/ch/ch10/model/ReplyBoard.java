package com.ch.ch10.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyBoard {
	private int rno;	// �Է� �Ҷ� ���� �ڵ����� 1�� ����
	private int bno;	// �� �Խñ� ��ȣ
	private String replytext; // ���
	private String replyer;	// ��� �ۼ���
	private Date regdate;	// �ۼ���
	private Date updatedate; // ������
	private String del;	// ����
}
