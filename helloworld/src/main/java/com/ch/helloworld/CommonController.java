package com.ch.helloworld;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ���� ��Ʈ�ѷ����� �������� ó���� �޼��带 ��� ���� Ŭ����
@ControllerAdvice
public class CommonController {
	@ExceptionHandler(Exception.class)
	public String err(Exception e, Model model) {
		model.addAttribute("e", e);
		return "err2";
	}
}
