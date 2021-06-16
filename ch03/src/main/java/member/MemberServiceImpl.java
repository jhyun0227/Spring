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
		// member2�� ��ȸ�� ȸ��, member�� �Է��� ȸ���̹Ƿ� �����ϱ� ����
		Member member2 = md.select(member.getId()); // �Է��Ϸ��� id �����Ͱ� �ִ��� Ȯ���Ͽ� �ߺ� üũ
		if (member2 == null) {
			result = md.insert(member);
		} else {
			System.out.println("�ߺ���  ���̵� �Դϴ�.");
		}
		return result;
	}

	public void select(String id) {
		Member member = md.select(id);
		if (member == null) {
			System.out.println("���� ���̵� �Դϴ�.");
		} else {
			print(member);
		}
	}

	private void print(Member member) {
		System.out.println("=======ȸ�� ����=======");
		System.out.println("���̵� : " + member.getId());
		System.out.println("�̸��� : " + member.getEmail());
		System.out.println("�̸� : " + member.getName());
		System.out.println("����� : " + member.getRegdate());
	}

	public void list() {
		List<Member> list = md.list();
		if (list == null || list.size() == 0) {
			System.out.println("�����Ͱ� �����ϴ�.");
		} else {
			for (Member member : list) {
				print(member);
			}
		}
	}

	public int update(Member member) {
		int result = 0;
		// member2�� ��ȸ�� ȸ��, member�� �Է��� ȸ���̹Ƿ� �����ϱ� ����
		Member member2 = md.select(member.getId()); // �Է��Ϸ��� id �����Ͱ� �ִ��� Ȯ���Ͽ� �ߺ� üũ
		if (member2 != null) {
			result = md.update(member);
		} else {
			System.out.println("���� ���̵��Դϴ�.");
		}
		return result;
	}

	public int delete(String id) {
		int result = 0;
		Member member = md.select(id);
		if (member != null) {
			result = md.delete(id);
		} else {
			System.out.println("���� ���̵�� ���� �� �� �����ϴ�.");
		}
		return result;
	}
}
