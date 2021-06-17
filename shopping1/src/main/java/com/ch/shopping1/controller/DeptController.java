package com.ch.shopping1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ch.shopping1.DeptService;
import com.ch.shopping1.model.Dept;

public class DeptController implements Controller{
	@Autowired
	private DeptService ds;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Dept> list = ds.list(); // 처리를 받음 2번
		mav.addObject("list", list);
		mav.setViewName("/WEB-INF/views/deptlist.jsp"); // view 선택 3번
		return mav; // 결과 출력 4번
	}

}
