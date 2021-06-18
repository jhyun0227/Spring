package com.ch.shopping2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.shopping2.model.Dept;
import com.ch.shopping2.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	
	@RequestMapping("deptList")
	public String deptList(Model model) {
		List<Dept> list = ds.list();
		model.addAttribute("list", list);
		return "deptList";	
	}
	
	@RequestMapping("deptDetail")
	public String deptDetail(String dname, Model model) {
		Dept dept = ds.select(dname);
		model.addAttribute("dept", dept);
		return "deptDetail";
	}
}
