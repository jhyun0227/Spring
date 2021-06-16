package hib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA ����ϰ� ORM �����ϴ� ȸ��
public class Person {
	private String id;
	private String name;
	
	@Id // id�� primary Key
	@Column(name = "id") // ������ table���� ����ϴ� key, ������ ���� ����
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
