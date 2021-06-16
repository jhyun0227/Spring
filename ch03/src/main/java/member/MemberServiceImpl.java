package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;
	private static Scanner sc;

	public int insert(Member member) {
		int result = 0;
		// member2는 조회한 회원, member는 입력한 회원이므로 구분하기 위함
		Member member2 = md.select(member.getId()); // 입력하려는 id 데이터가 있는지 확인하여 중복 체크
		if (member2 == null) {
			result = md.insert(member);
		} else {
			System.out.println("중복된  아이디 입니다.");
		}
		return result;
	}

	public void select(String id) {
		Member member = md.select(id);
		if (member == null) {
			System.out.println("없는 아이디 입니다.");
		} else {
			print(member);
		}
	}

	private void print(Member member) {
		System.out.println("=======회원 정보=======");
		System.out.println("아이디 : " + member.getId());
		System.out.println("이메일 : " + member.getEmail());
		System.out.println("이름 : " + member.getName());
		System.out.println("등록일 : " + member.getRegdate());
	}

	public void list() {
		List<Member> list = md.list();
		if (list == null || list.size() == 0) {
			System.out.println("데이터가 없습니다.");
		} else {
			for (Member member : list) {
				print(member);
			}
		}
	}

	public int update(Member member) {
		int result = 0;
		// member2는 조회한 회원, member는 입력한 회원이므로 구분하기 위함
		Member member2 = md.select(member.getId()); // 입력하려는 id 데이터가 있는지 확인하여 중복 체크
		if (member2 != null) {
			result = md.update(member);
		} else {
			System.out.println("없는 아이디입니다.");
		}
		return result;
	}

	public int delete(String id) {
		int result = 0;
		Member member = md.select(id);
		if (member != null) {
			result = md.delete(id);
		} else {
			System.out.println("없는 아이디는 삭제 할 수 없습니다.");
		}
		return result;
	}
}
