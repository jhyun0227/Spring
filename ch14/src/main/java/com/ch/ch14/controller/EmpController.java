package com.ch.ch14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch14.Service.DeptService;
import com.ch.ch14.Service.EmpService;
import com.ch.ch14.model.Dept;
import com.ch.ch14.model.Emp;

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
	
	@RequestMapping("empInsert")
	public String empInsert(Emp emp, Model model) {
		int result = 0;
		// emp�� ȭ�鿡�� �Է��� ��, emp2�� ������� DB �ߺ�Ȯ���� ���� ��� 
		Emp emp2 = es.select(emp.getEmpno());
		if (emp2 == null) {
			result = es.insert(emp);
		} else {
			result = -1; // �̹� �����ϴ� ������� �Է� �Ұ�
		}
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empInsert";
	}
	
	@RequestMapping("empUpdateForm")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.select(empno);
		List<Emp> empList = es.empList();
		List<Dept> deptList = ds.list();
		model.addAttribute("emp", emp);
		model.addAttribute("empList", empList);
		model.addAttribute("deptList", deptList);
		return "/emp/empUpdateForm";
	}
	
	@RequestMapping("empUpdate")
	public String empUpdate(Emp emp, Model model) {
		int result = es.update(emp);
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empUpdate";
	}
	
	@RequestMapping("empDelete")
	public String empDelete(int empno, Model model) {
		Emp emp = es.select(empno);
		int result = es.delete(empno);
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empDelete";
	}
	
	@RequestMapping("allEmpList")
	public String allEmpList(Model model) {
		List<Emp> list = es.list();
		model.addAttribute("list", list);
		return "/emp/allEmpList";
	}
}