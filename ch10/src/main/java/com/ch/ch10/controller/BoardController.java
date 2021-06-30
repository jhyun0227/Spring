package com.ch.ch10.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ch10.model.Board;
import com.ch.ch10.service.BoardService;
import com.ch.ch10.service.PagingBean;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@RequestMapping("/list")
	public String init() {
		return "redirect:/list/pageNum/1";
	}
	
	@RequestMapping("/list/pageNum/{pageNum}")
	public String list(Board board, @PathVariable String pageNum, Model model) {
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 10; // �� ȭ�鿡 �����ִ� �Խñ��� ����
//		int total = bs.getTotal();
		int total = bs.getTotal(board); // �˻� ������ ����
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		board.setStartRow(startRow);
		board.setEndRow(endRow);
//		List<Board> list = bs.list(startRow, endRow);
		List<Board> list = bs.list(board); // �˻� ������ ����
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		int num = total - startRow + 1;
		
		String[] title = {"�ۼ���", "����", "����", "����+����"};
		
//		model.addAttribute("board", board); �Ű������� �Ѿ�� �����͸� �ٽ� ������ ������ model.addAttribute() ���� ����
		model.addAttribute("title", title);
		model.addAttribute("pb", pb);
		model.addAttribute("list", list);
		model.addAttribute("num", num);
		return "list";
	}
	
	@RequestMapping("/insertForm/num/{num}/pageNum/{pageNum}")
	public String insertForm(@PathVariable int num, @PathVariable String pageNum, Model model) {
		int ref=0, re_level=0, re_step=0;
		if (num != 0) { // �亯��
			Board board = bs.select(num);
			ref = board.getRef();
			re_step = board.getRe_step();
			re_level = board.getRe_level();
		}
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("ref", ref);
		model.addAttribute("re_level", re_level);
		model.addAttribute("re_step", re_step);
		return "insertForm";
	}
	
	@RequestMapping("/insert")
	public String insert(Board board, String pageNum, Model model, HttpServletRequest request) {
		// ip�� ������ �ʿ䰡 �ִ� ���
		board.setIp(request.getRemoteAddr());
		int number = bs.getMaxNum(); // �Խñ� �۹�ȣ ����
		if (board.getNum() != 0) { // �亯��
			// ���� �а� ref�� ���� re_step�� ���� ���� re_step���� ũ�� �� ���� re_step + 1
			bs.updateStep(board);
			board.setRe_level(board.getRe_level()+1);
			board.setRe_step(board.getRe_step()+1);
			// �亯���� ref�� ���� ���� ref�� �״�� ���
		} else {
			board.setRef(number); // �亯���� �ƴ� ���� num�� ����
		}
		board.setNum(number);
		int result = bs.insert(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "insert";
	}
	
//	@RequestMapping("view")
	@RequestMapping("/view/num/{num}/pageNum/{pageNum}")
	public String view(@PathVariable int num, @PathVariable int pageNum, Model model) {
		bs.updateReadCount(num); // ��ȸ�� ����
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "view";
	}
	
	@RequestMapping("/updateForm/num/{num}/pageNum/{pageNum}")
	public String updateForm(@PathVariable int num, @PathVariable int pageNum, Model model) {
		Board board = bs.select(num);
		System.out.println(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "updateForm";
	}
	
	@RequestMapping("/update")
	public String update(Board board, int pageNum, Model model) {
		int result = bs.update(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("board", board); // �� �������� �̵��� �� �ֵ��� �ϱ� ���� ������ ������
		return "update";
	}
	
	@RequestMapping("/deleteForm/num/{num}/pageNum/{pageNum}")
	public String deleteForm(@PathVariable int num, @PathVariable int pageNum, Model model) {
		Board board = bs.select(num); // ��ȣȮ���� ����
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "deleteForm";
	}
	
	@RequestMapping("/delete")
	public String delete(int num, int pageNum, Model model) {
		int result = bs.delete(num);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "delete";
	}
	
}
