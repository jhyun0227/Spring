package com.ch.ch14.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp")
public class Emp {
//	hibernate �Ǵ� JPA���� ���ںκп� null�� ������ �����̰� Integer�� ����ó�� ��
	@Id
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
	// join��
	private Dept dept;

	@Id // id�� primary key
	@Column(name = "empno")
	public int getEmpno() {
		return empno;
	}

	@ManyToOne
	@JoinColumn(name = "deptno", referencedColumnName = "deptno", insertable = false, updatable = false)
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}