package samp04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class a4_Ex01 {
//	결정한다 --> 제어한다
//  제어의 역전 IoC(Inversion of Control) : loosely coupled 결합도를 느슨하게 만든다.
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans02.xml");
//		a1_Vehicle vh = ac.getBean("vh", a1_Vehicle.class);
//		a1_Vehicle vh = (a1_Vehicle)ac.getBean("vh");
		a1_Vehicle vh = ac.getBean(a1_Vehicle.class);
		vh.ride("준호");
		ac.close();
	}
}
