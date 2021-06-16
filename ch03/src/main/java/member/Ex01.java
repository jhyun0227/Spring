package member;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex01 {
	private static MemberService ms; // Ŭ���� ����, ��ü �������� �ʰ� ���
	private static Scanner sc; // ��������

	public static void main(String[] args) {
		AbstractApplicationContext ac = new GenericXmlApplicationContext("db.xml");
		ms = ac.getBean(MemberService.class);
		sc = new Scanner(System.in);
		while (true) {
			help();
			String command = sc.nextLine();
			if (command.equals("1")) {
				break;
			} else if (command.equals("2")) {
				insert();
			} else if (command.equals("3")) {
				update();
			} else if (command.equals("4")) {
				delete();
			} else if (command.equals("5")) {
				select();
			} else if (command.equals("6")) {
				list();
			}
		}
		ac.close();
		sc.close();
		System.out.println("���α׷� ����");
	}

	private static void delete() {
		System.out.println("������ ���̵� �Է��ϼ���");
		String id = sc.nextLine();
		int result = ms.delete(id);
		if (result > 0) {
			System.out.println("���� �Ϸ�");
		}
	}

	private static void update() {
		System.out.println("������ ���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		System.out.println("�̸����� �Է��ϼ���.");
		String email = sc.nextLine();
		System.out.println("��ȣ�� �Է��ϼ���.");
		String password = sc.nextLine();
		System.out.println("��ȣ Ȯ���� �Է��ϼ���.");
		String confirmPass = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ���.");
		String name = sc.nextLine();

		if (!password.equals(confirmPass)) {
			System.out.println("��ȣ�� ��ȣȮ���� �ٸ��ϴ�.");
			return;
		}

		Member member = new Member();
		member.setId(id);
		member.setEmail(email);
		member.setPassword(password);
		member.setName(name);
		int result = ms.update(member);
		if (result > 0) {
			System.out.println("���� ����");
		}
	}

	private static void list() {
		ms.list();
	}

	private static void select() {
		System.out.println("��ȸ�� ���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		ms.select(id);
	}

	private static void insert() {
		System.out.println("���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		System.out.println("�̸����� �Է��ϼ���.");
		String email = sc.nextLine();
		System.out.println("��ȣ�� �Է��ϼ���.");
		String password = sc.nextLine();
		System.out.println("��ȣ Ȯ���� �Է��ϼ���.");
		String confirmPass = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ���.");
		String name = sc.nextLine();

		if (!password.equals(confirmPass)) {
			System.out.println("��ȣ�� ��ȣȮ���� �ٸ��ϴ�.");
			return;
		}

		Member member = new Member();
		member.setId(id);
		member.setEmail(email);
		member.setPassword(password);
		member.setName(name);
		int result = ms.insert(member);
		if (result > 0) {
			System.out.println("�Է� ����");
		}
	}

	private static void help() {
		System.out.println("��ɾ �����ϼ���.");
		System.out.println("1. ����");
		System.out.println("2. �Է�");
		System.out.println("3. ����");
		System.out.println("4. ����");
		System.out.println("5. ��ȸ");
		System.out.println("6. ���");

	}
}
