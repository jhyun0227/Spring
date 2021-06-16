package samp02;

public class a4_Ex01 {
//	결합도를 떨어지게 만든다(느슨하게 만든다)	
	public static void main(String[] args) {
//		a1_MessageBean mb = new a3_MessageBeanEn();
		a1_MessageBean mb = new a2_MessageBeanKr();
		mb.sayHello("바이든");		
	}
}
