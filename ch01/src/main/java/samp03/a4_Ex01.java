package samp03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
// Ex01 a2_MessageBeanKr, a3_MessageBeanEn ���յ��� ����߷ȴ�.
public class a4_Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans01.xml");
		a1_MessageBean mb = ac.getBean("mb", a1_MessageBean.class);
		mb.sayHello("���̵�");
		ac.close();
	}
}
// c + s + o ������� �ʴ� ���� import���� �������ش�.