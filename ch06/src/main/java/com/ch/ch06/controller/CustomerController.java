package com.ch.ch06.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ch.ch06.model.Customer;
import com.ch.ch06.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService cs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init() {
//		forward �Ǵ� redirect�� ��쿡�� jsp�� �ƴ϶� Controller �� �ٸ� �޼��� ȣ��
		return "forward:/customer";
	}
	
	// RequestMethod.GET get���� ��û���� ��쿡 ����
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String list(Model model) {
		Collection<Customer> customers = cs.list();
		model.addAttribute("customers", customers);
		return "/customer/list";
	}
	
	@RequestMapping("/customer/{id}")
	// @PathVariable�� {}�� ����ִ� ���� ���� ���� �� ���
	public String detail(@PathVariable int id, Model model) {
		Customer customer = cs.select(id);
		model.addAttribute("customer", customer);
		return "/customer/detail";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		cs.delete(id);
		return "/customer/delete";
	}
}
