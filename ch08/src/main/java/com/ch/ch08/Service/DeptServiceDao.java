package com.ch.ch08.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch08.dao.DeptDao;
import com.ch.ch08.model.Dept;

@Service
public class DeptServiceDao implements DeptService {
	@Autowired
	private DeptDao dd;

	@Override
	public List<Dept> list() {
		return dd.list();
	}

	@Override
	public Dept select(int deptno) {
		return dd.select(deptno);
	}

	@Override
	public int insert(Dept dept) {
		return dd.insert(dept);
	}

	@Override
	public int update(Dept dept) {
		return dd.update(dept);
	}

	@Override
	public int delete(int deptno) {
		return dd.delete(deptno);
	}
}
