package samp03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
// Ex01 a2_MessageBeanKr, a3_MessageBeanEn 결합도를 떨어뜨렸다.
public class a4_Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans01.xml");
		a1_MessageBean mb = ac.getBean("mb", a1_MessageBean.class);
		mb.sayHello("바이든");
		ac.close();
	}
}
// c + s + o 사용하지 않는 것을 import에서 제외해준다.