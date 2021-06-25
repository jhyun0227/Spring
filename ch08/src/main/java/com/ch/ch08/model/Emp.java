package com.ch.ch08.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	// hibernate �Ǵ� JPA���� ���� �κп� null�� ������ �����̰� Interger�� ����ó�� ��
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private int sal;
	private Integer comm;
	private int deptno;
	// ������ �̸�
	private String mgrName;
	// join �ϱ� ����
	private Dept dept;
}
