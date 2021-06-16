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
}
