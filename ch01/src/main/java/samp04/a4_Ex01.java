package samp04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class a4_Ex01 {
//	�����Ѵ� --> �����Ѵ�
//  ������ ���� IoC(Inversion of Control) : loosely coupled ���յ��� �����ϰ� �����.
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans02.xml");
//		a1_Vehicle vh = ac.getBean("vh", a1_Vehicle.class);
//		a1_Vehicle vh = (a1_Vehicle)ac.getBean("vh");
		a1_Vehicle vh = ac.getBean(a1_Vehicle.class);
		vh.ride("��ȣ");
		ac.close();
	}
}
