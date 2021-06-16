package hib.dao;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hib.model.Person;
import hib.service.PersonService;

public class Ex01 {
	private static PersonService ps;
	private static Scanner sc;

	public static void main(String[] args) {
		AbstractApplicationContext ac = new GenericXmlApplicationContext("classpath:db.xml");
		ps = ac.getBean(PersonService.class);
		sc = new Scanner(System.in);
		String command = "";
		while (true) {
			help();
			command = sc.nextLine();
			if (command.equals("6")) {
				break;
			} else if (command.equals("1")) {
				insert();
			}
		}
		sc.close();
		ac.close();
		System.out.println("���α׷� ����");
	}

	private static void insert() {
		System.out.println("���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		
		int result = ps.insert(person);
		
		if (result > 0) {
			System.out.println("�Է� ����");
		}
	}

	private static void help() {
		System.out.println();
		System.out.println("��ɾ �Է��ϼ���.");
		System.out.println("1. �Է�");
		System.out.println("2. ��ȸ");
		System.out.println("3. ����");
		System.out.println("4. ����");
		System.out.println("5. ���");
		System.out.println("6. ����");
		System.out.print("===> ");
	}
}
