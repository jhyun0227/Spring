package com.ch.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch08.Service.DeptService;
import com.ch.ch08.Service.EmpService;
import com.ch.ch08.model.Dept;
import com.ch.ch08.model.Emp;

@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	@Autowired
	private DeptService ds;
	
	@RequestMapping("empList")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		List<Emp> empList = es.list(deptno);
		model.addAttribute("dept", dept);
		model.addAttribute("empList", empList);
		return "/emp/empList";
	}
	
	@RequestMapping("empSelect")
	public String empSelect(int empno, Model model) {
		Emp emp = es.select(empno);
		model.addAttribute("emp", emp);
		return "/emp/empSelect";
	}
	
	@RequestMapping("empInsertForm")
	public String empInsertForm(int deptno, Model model) {
		List<Dept> deptList = ds.list(); // �μ��ڵ� ������ �� �ְ�
		List<Emp> empList = es.empList(); // ������ ���
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		model.addAttribute("deptno", deptno);
		return "/emp/empInsertForm";
	}
	
	@RequestMapping(value = "empNoChk", produces = "text/html;charset=utf-8")
	@ResponseBody // jsp�� �������� �ٷ� �������� ����
	public String empNoChk(int empno, Model model) {
		String data = "";
		Emp emp = es.select(empno);
		if (emp == null) {
			data = "��� ���� �� ����Դϴ�.";
		} else {
			data = "�̹� ������� ��� �Դϴ�.";
		}
		return data;
	}
}
