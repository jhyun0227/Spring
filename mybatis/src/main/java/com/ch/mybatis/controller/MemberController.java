package com.ch.mybatis.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.mybatis.Service.MemberService;
import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@RequestMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping("joinForm2")
	public String joinForm2() {
		return "joinForm2";
	}
	
//	@RequestMapping("idChk")
//	public String idChk(String id, Model model ) {
//		String msg="";
//		Member member = ms.select(id);
//		if (member == null) {
//			msg = "사용 가능 한 아이디 입니다.";
//		} else {
//			msg = "이미 사용중인 아이디 입니다.";
//		}
//		model.addAttribute("msg", msg);
//		return "idChk";
//	}
										// 한글 깨지지 말라고 사용
	@RequestMapping(value = "idChk", produces = "text/html;charset=utf-8")
	@ResponseBody // jsp로 가지말고 바로 본문으로 전달
	public String idChk(String id) {
		String msg="";
		Member member = ms.select(id);
		if (member == null) {
			msg = "사용 가능 한 아이디 입니다.";
		} else {
			msg = "이미 사용중인 아이디 입니다.";
		}
		return msg;
	}
	
	@RequestMapping("join")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터이고 member2는 DB에서 id로 읽은 데이터
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			String fileName = member.getFile().getOriginalFilename();
			member.setFileName(fileName);
			String real = session.getServletContext().getRealPath("/resources/upload");
			FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			result = ms.insert(member);
		} else {
			result = -1; // 이미 있는 데이터
		}
		model.addAttribute("result", result);
		return "join";
	}
	
	@RequestMapping("join2")
	public String join2(Member member, Model model, HttpSession session, MultipartHttpServletRequest mhr) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터이고 member2는 DB에서 id로 읽은 데이터
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			// 여러개 파일명을 한번에 받아옴
			List<MultipartFile> list = mhr.getFiles("file");
			// 사진을 여러개 가진 list, 하나 씩 photo에 저장하고 그것을 photos에 add
			List<MemberPhoto> photos = new ArrayList<MemberPhoto>();
			String real = session.getServletContext().getRealPath("/resources/upload");
			// list의 사진을 하나씩 뽑아서 photos로 저장
			for (MultipartFile mf : list) {
				MemberPhoto mp = new MemberPhoto();
				String fileName = mf.getOriginalFilename();
				mp.setFileName(fileName);
				mp.setId(member.getId());
				// photos에는 그림 하나짜리 mp가 여러개 저장
				photos.add(mp);
				// 파일 업로드
				FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
				fos.write(mf.getBytes());
				fos.close();
				member.setFileName(fileName);
			}
			result = ms.insert(member);
			if (result > 0) {
				ms.insertPhoto(photos);
			}
		} else {
			result = -1; // 이미 있는 데이터
		}
		model.addAttribute("result", result);
		return "join";
	}
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("login")
	public String login(Member member, Model model, HttpSession session) {
		int result = 0;
		Member member2 = ms.select(member.getId());
		/*if (member2 != null || member2.getDel().equals("n")) {
			if (member2.getPassword().equals(member.getPassword())) {
				session.setAttribute("id", member.getId());
				result = 1;
			} else {
				result = 0;
			}
		} else {
			result = -1;
		}*/
		if (member2 == null || member2.getDel().equals("y")) {
			result = -1; // 없는 아이디
		} else if (member2.getPassword().equals(member.getPassword())) {
			result = 1; // 성공 id와 password 일치
			session.setAttribute("id", member.getId());
		}
		model.addAttribute("result", result);
		return "login";
	}
	
	@RequestMapping("main")
	public String main(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = null;
		if (id != null && !id.equals("")) {
			member= ms.select(id);
			model.addAttribute("member", member);
		}
		return "main";
	}
	
	@RequestMapping("view")
	public String view(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "view";
	}
	
	@RequestMapping("view2")
	public String view2(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		List<MemberPhoto> list = ms.listPhoto(id);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
		return "view2";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "updateForm";
	}
	
	@RequestMapping("update")
	public String update(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// fileName은 null일수 도 있고 값을 가져 올 수도 있다. 이미지를 바꿀 수도 안바꿀 수도
		String fileName = member.getFile().getOriginalFilename();
		if (fileName != null && !fileName.equals("")) {
			member.setFileName(fileName);
			String real = session.getServletContext().getRealPath("/resources/upload");
			FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
		}
		result = ms.update(member);
		model.addAttribute("result", result);
		return "update";
	}
	
	@RequestMapping("delete")
	public String delete(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		int result = ms.delete(id);
		if (result > 0) {
			session.invalidate();
		}
		model.addAttribute("result", result);
		return "delete";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}
