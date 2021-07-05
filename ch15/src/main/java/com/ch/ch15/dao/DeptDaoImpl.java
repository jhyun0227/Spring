package com.ch.ch15.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ch.ch15.model.Dept;

@Repository
public class DeptDaoImpl implements DeptDao{
	@Autowired
	private HibernateTemplate ht;

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> list() {
		return (List<Dept>) ht.find("from Dept");
	}

	@Override
	public Dept select(int deptno) {
		return ht.get(Dept.class, deptno);
	}

	@Override
	public int insert(Dept dept) {
		ht.save(dept);
		return 1;
	}

	@Override
	public int update(Dept dept) {
		ht.update(dept);
		return 1;
	}

	@Override
	public int delete(int deptno) {
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		ht.delete(dept);
		return 1;
	}
}
