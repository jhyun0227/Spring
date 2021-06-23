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
// 클래스에 @RequestMapping을 정의하면 클래스의 모든 메소드에 공통으로 사용
@RequestMapping("/customer/{id}")
// 이 session 있는 컨틀롤러에서 editCustomer라는 이름으로 저장하여 같이 사용
@SessionAttributes("editCustomer")
public class EditController {
	@Autowired
	private CustomerService cs;
	
	@RequestMapping("/edit") // /customer/{id}/edit와 같음
	public String edit(@PathVariable int id, Model model) {
		Customer customer = cs.select(id);
//		customer에 있는 데이터를 editCustomer라는 이름으로 jsp에 전달
		model.addAttribute("editCustomer", customer);
		return "redirect:enter";
	}
//	redirect:enter @RequestMapping("/customer/{id}/enter")
//	redirect:/enter @RequestMapping("/enter")
	@RequestMapping(value = "/enter", method = RequestMethod.GET) // /customer/{id}/enter
//	@ModelAttribute 객체로 된 데이터를 받아올때 사용
	public String enter(@ModelAttribute("editCustomer") Customer customer) {
		return "/customer/edit/enter";
	}
}
