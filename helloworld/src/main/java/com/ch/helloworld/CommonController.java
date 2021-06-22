package com.ch.helloworld;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 여러 컨트롤러에서 공동으로 처리할 메서드를 모아 놓은 클래스
@ControllerAdvice
public class CommonController {
	@ExceptionHandler(Exception.class)
	public String err(Exception e, Model model) {
		model.addAttribute("e", e);
		return "err2";
	}
}
