package samp13;

public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name; this.price = price;
	}
	
	public String toString() {
		return "��ǰ[�̸�:"+name+", ����:"+price+"]";
	}
}
