package com.ch.helloworld;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("addrForm")
	public String addrForm() {
		return "addrForm";
	}
	
	@RequestMapping("addr")
	public String addr(HttpServletRequest request, Model model) {
		// addrForm에서 데이터 받기
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		// jsp로 데이터 보내기
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}
	
	@RequestMapping("addr2")
	public String addr2(String name, String addr, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}
	
	@RequestMapping("addr3")
	public String addr3(Person person, Model model) {
		model.addAttribute("person", person);
		return "addr3";
	}
	
	@RequestMapping("memberForm")
	public String memberFrom() {
		return "memberForm";
	}
	
	@RequestMapping("member")
	public String member(Member member, Model model) {
		model.addAttribute("member", member);
		return "member";
	}
	
	@RequestMapping("calForm")
	public String calForm() {
		return "calForm";
	}
	
	@RequestMapping("cal")
	public String cal(int num1, int num2, Model model) {
		model.addAttribute("add", num1+num2);
		model.addAttribute("min", num1-num2);
		model.addAttribute("mul", num1*num2);
		model.addAttribute("div1", num1/num2);
		return "cal";
	}
	
//	// 현재 컨트롤러에서 발생한 에러만 처리
//	@ExceptionHandler(ArithmeticException.class)
//	public String err1() {
//		return "err1";
//	}
}
