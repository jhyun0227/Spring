package com.ch.ch15.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "dept")
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	@Id
	@Column(name = "deptno") // ���� table�� key�� �̸��� ������ ���� ����
	public int getDeptno() {
		return deptno;
	}
}
