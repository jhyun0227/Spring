package com.ch.shopping1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.shopping1.Dao.DeptDao;
import com.ch.shopping1.model.Dept;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dd;
	
	@Override
	public List<Dept> list() {
		return dd.list();
	}

}
