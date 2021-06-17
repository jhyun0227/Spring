package com.ch.shopping1.model;

import lombok.Data;

@Data // getter setter 메소드 만들어줌
public class Item {
	private int itemId;
	private String itemName;
	private int price;
	private String description;
	private String pictureUrl;
}
