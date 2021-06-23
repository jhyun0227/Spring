package com.ch.ch06.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.ch.ch06.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private Map<Integer, Customer> map = new HashMap<Integer, Customer>();
	private int nextId;

	@PostConstruct // ��ü�� ������ �Ŀ� ���� ����
	public void init() {
		// cutomer��ü 4���� �����Ͽ� map�������� �޸𸮿� ����
		register(new Customer("����", "����", "k1@k.com"));
		register(new Customer("����", "����", "k2@k.com"));
		register(new Customer("���", "����", "k3@k.com"));
		register(new Customer("����", "�뱸", "k4@k.com"));
	}

	private void register(Customer customer) {
		customer.setId(++nextId); // 1�� �����Ͽ� Id���� ����
		map.put(customer.getId(), customer);
	}

	@Override
	public Collection<Customer> list() {
		return map.values();
	}

	@Override
	public Customer select(int id) {
		return map.get(id);
	}

	@Override
	public void delete(int id) {
		map.remove(id);
	}

	@Override
	public void update(Customer customer) {
		// ��ü ���� ��� ����
		map.put(customer.getId(), customer);
	}
}