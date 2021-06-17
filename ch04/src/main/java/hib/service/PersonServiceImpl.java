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
		// person2는 DB에서 읽어온 데이터.
		Person person2 = pd.select(person.getId()); // 중복 체크
		if (person2 == null) {
			pd.save(person);
			result = 1;
		} else {
			System.out.println("존재하는 아이디입니다.");
		}
		return result;
	}

	public void select(String id) {
		Person person = pd.select(id); // 중복 체크
		if (person == null) {
			System.out.println("없는 아이디 입니다.");
		} else {
			print(person);
		}
	}

	private void print(Person person) {
		System.out.println("=====회원 정보=====");
		System.out.println("아이디 : " + person.getId());
		System.out.println("이름 : " + person.getName());
	}

	public int update(Person person) {
		int result = 0;
		// person2는 DB에서 읽어온 데이터.
		Person person2 = pd.select(person.getId()); // 중복 체크
		if (person2 != null) {
			pd.update(person);
			result = 1;
		} else {
			System.out.println("없는 아이디는 수정 할 수 없습니다.");
		}
		return result;
	}

	public void list() {
		List<Person> list = pd.list();
		if (list == null || list.size() == 0) {
			System.out.println("아이디가 없습니다.");
		} else {
			for (Person person : list) {
				print(person);
			}
		}
	}

	public int delete(String id) {
		int result = 0;
		// person2는 DB에서 읽어온 데이터.
		Person person2 = pd.select(id); // 중복 체크
		if (person2 != null) {
			pd.delete(id);
			result = 1;
		} else {
			System.out.println("없는 아이디는 삭제 할 수 없습니다.");
		}
		return result;
	}
}
