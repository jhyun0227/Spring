package samp05;

public class a2_MessageBeanImpl implements a1_MessageBean {
	private String name;
	private String greeting;
	
//	생성자를 통해서 이름과 인사말을 받자
	public a2_MessageBeanImpl(String name, String greeting) {
		this.name = name; this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(name + ", " + greeting);
	}	
}
