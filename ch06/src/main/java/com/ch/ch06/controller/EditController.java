package com.ch.ch06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ch.ch06.model.Customer;
import com.ch.ch06.service.CustomerService;

@Controller
// Ŭ������ @RequestMapping�� �����ϸ� Ŭ������ ��� �޼ҵ忡 �������� ���
@RequestMapping("/customer/{id}")
// �� session �ִ� ��Ʋ�ѷ����� editCustomer��� �̸����� �����Ͽ� ���� ���
@SessionAttributes("editCustomer")
public class EditController {
	@Autowired
	private CustomerService cs;
	
	@RequestMapping("/edit") // /customer/{id}/edit�� ����
	public String edit(@PathVariable int id, Model model) {
		Customer customer = cs.select(id);
//		customer�� �ִ� �����͸� editCustomer��� �̸����� jsp�� ����
		model.addAttribute("editCustomer", customer);
		return "redirect:enter";
	}
//	redirect:enter @RequestMapping("/customer/{id}/enter")
//	redirect:/enter @RequestMapping("/enter")
	@RequestMapping(value = "/enter", method = RequestMethod.GET) // /customer/{id}/enter
//	@ModelAttribute ��ü�� �� �����͸� �޾ƿö� ���
	public String enter(@ModelAttribute("editCustomer") Customer customer) {
		return "/customer/edit/enter";
	}
}
