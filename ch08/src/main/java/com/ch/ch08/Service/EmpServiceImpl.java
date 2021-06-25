package com.ch.ch08.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch08.dao.EmpDao;
import com.ch.ch08.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;

	@Override
	public List<Emp> list(int deptno) {
		return ed.list(deptno);
	}

	@Override
	public Emp select(int empno) {
		return ed.select(empno);
	}

	@Override
	public List<Emp> empList() {
		return ed.empList();
	}
}
