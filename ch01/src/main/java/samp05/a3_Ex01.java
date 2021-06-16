package samp05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
// DI Dependency Injection ������ ���� : ������ ����(IoC)�� ���谡 ���.
// AOP ���� ���� ���α׷��� : ���������� �ַ� ���
public class a3_Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans02.xml");
//		a1_MessageBean mb = ac.getBean(a1_MessageBean.class);
		a1_MessageBean mb = (a1_MessageBean)ac.getBean("a");
		mb.sayHello();
		ac.close();
	}
}
