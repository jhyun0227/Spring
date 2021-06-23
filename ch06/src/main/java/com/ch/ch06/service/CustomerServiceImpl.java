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

	@PostConstruct // 객체를 생성한 후에 먼저 실행
	public void init() {
		// cutomer객체 4개를 생성하여 map형식으로 메모리에 저장
		register(new Customer("승희", "마포", "k1@k.com"));
		register(new Customer("제니", "신촌", "k2@k.com"));
		register(new Customer("비룡", "강남", "k3@k.com"));
		register(new Customer("영웅", "대구", "k4@k.com"));
	}

	private void register(Customer customer) {
		customer.setId(++nextId); // 1씩 증가하여 Id값을 셋팅
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
		// 전체 값을 덮어서 수정
		map.put(customer.getId(), customer);
	}
}