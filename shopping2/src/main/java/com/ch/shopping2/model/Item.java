package com.ch.shopping2.model;

import lombok.Data;

@Data // getter setter �޼ҵ� �������
public class Item {
	private int itemId;
	private String itemName;
	private int price;
	private String description;
	private String pictureUrl;
}
