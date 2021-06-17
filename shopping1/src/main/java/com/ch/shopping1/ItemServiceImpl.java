package com.ch.shopping1;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.ch.shopping1.Dao.ItemDao;
import com.ch.shopping1.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao id;

	@Override
	public List<Item> list() {
		return id.list();
	}
}
