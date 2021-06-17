package hib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hib.dao.PersonDao;
import hib.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao pd;

	public int insert(Person person) {
		int result = 0;
		// person2�� DB���� �о�� ������.
		Person person2 = pd.select(person.getId()); // �ߺ� üũ
		if (person2 == null) {
			pd.save(person);
			result = 1;
		} else {
			System.out.println("�����ϴ� ���̵��Դϴ�.");
		}
		return result;
	}

	public void select(String id) {
		Person person = pd.select(id); // �ߺ� üũ
		if (person == null) {
			System.out.println("���� ���̵� �Դϴ�.");
		} else {
			print(person);
		}
	}

	private void print(Person person) {
		System.out.println("=====ȸ�� ����=====");
		System.out.println("���̵� : " + person.getId());
		System.out.println("�̸� : " + person.getName());
	}

	public int update(Person person) {
		int result = 0;
		// person2�� DB���� �о�� ������.
		Person person2 = pd.select(person.getId()); // �ߺ� üũ
		if (person2 != null) {
			pd.update(person);
			result = 1;
		} else {
			System.out.println("���� ���̵�� ���� �� �� �����ϴ�.");
		}
		return result;
	}

	public void list() {
		List<Person> list = pd.list();
		if (list == null || list.size() == 0) {
			System.out.println("���̵� �����ϴ�.");
		} else {
			for (Person person : list) {
				print(person);
			}
		}
	}

	public int delete(String id) {
		int result = 0;
		// person2�� DB���� �о�� ������.
		Person person2 = pd.select(id); // �ߺ� üũ
		if (person2 != null) {
			pd.delete(id);
			result = 1;
		} else {
			System.out.println("���� ���̵�� ���� �� �� �����ϴ�.");
		}
		return result;
	}
}
