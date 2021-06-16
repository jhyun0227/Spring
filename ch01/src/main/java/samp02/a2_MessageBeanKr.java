package samp02;
// interface를 구현한다는 것은 interface에 있는 메서드 overriding 해야함.
public class a2_MessageBeanKr implements a1_MessageBean {
	public void sayHello(String name) {
		System.out.println("안녕하세요, " + name + "!");
	}

}
