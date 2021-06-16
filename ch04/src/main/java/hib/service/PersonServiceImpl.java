package hib.service;

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
}
