package com.ch.ch08.Service;

import java.util.List;

import com.ch.ch08.model.Emp;

public interface EmpService {
	List<Emp> list(int deptno);

	Emp select(int empno);

	List<Emp> empList();

}
