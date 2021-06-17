package hib.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hib.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private HibernateTemplate ht;

	public Person select(String id) {
		return ht.get(Person.class, id);
	}

	public void save(Person person) {
		ht.save(person);
	}

	public void update(Person person) {
		ht.update(person);		
	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {
		// ���� ���� Person�� ���̺� ���� �ƴ� Ŭ������ �빮�ڷ� ����
		return (List<Person>) ht.find("from Person");
	}

	public void delete(String id) {
		Person person = new Person();
		person.setId(id);
		// ��ü�� �����ϰ� ��ü�� key�� setting �� �� ��ü�� ����
		ht.delete(person);
	}
}
