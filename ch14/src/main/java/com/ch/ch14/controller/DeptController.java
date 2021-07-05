package com.ch.ch14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch14.model.Dept;
import com.ch.ch14.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService ds;

	@RequestMapping("deptList")
	public String deptList(Model model) {
		List<Dept> deptList = ds.list();
		model.addAttribute("deptList", deptList);
		return "/dept/deptList";
	}

	@RequestMapping("insertDeptForm")
	public String insertDeptForm() {
		return "/dept/insertDeptForm";
	}

	@RequestMapping("deptInsert")
	public String deptInsert(Dept dept, Model model) {
		int result = 0;
		Dept dept2 = ds.select(dept.getDeptno());
		if (dept2 == null) {
			Dept dt = ds.insert(dept);
			if (dt != null)
				result = 1;
		} else
			result = -1; // �ߺ��� ������ �Է�
		model.addAttribute("result", result);
		return "/dept/deptInsert";
	}

	@RequestMapping("updateDeptForm")
	public String updateDeptForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "/dept/updateDeptForm";
	}

	@RequestMapping("deleteDept")
	public String deleteDept(int deptno, Model model) {
		int result = ds.delete(deptno);
		model.addAttribute("result", result);
		return "/dept/deleteDept";
	}

	@RequestMapping("deptUpdate")
	public String deptUpdate(Dept dept, Model model) {
		Dept result = ds.update(dept);
		model.addAttribute("result", result);
		return "/dept/deptUpdate";
	}

	@RequestMapping(value = "deptNoChk", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String deptNoChk(int deptno) {
		String data = "";
		Dept dept = ds.select(deptno);
		if (dept == null)
			data = "��밡���� �μ��ڵ� �Դϴ�";
		else
			data = "������̴� �ٸ� �μ��ڵ带 ����Ͻÿ�";
		return data;
	}
}