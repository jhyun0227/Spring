package samp05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
// DI Dependency Injection 의존성 주입 : 제어의 역전(IoC)과 관계가 깊다.
// AOP 관점 지향 프로그래밍 : 공통팀에서 주로 사용
public class a3_Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans02.xml");
//		a1_MessageBean mb = ac.getBean(a1_MessageBean.class);
		a1_MessageBean mb = (a1_MessageBean)ac.getBean("a");
		mb.sayHello();
		ac.close();
	}
}
