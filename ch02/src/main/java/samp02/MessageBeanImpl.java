package samp02;

public class MessageBeanImpl implements MessageBean {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		try {
			Thread.sleep(500); // 0.5�� �����
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(name + "�� �ȳ��ϼ���.");
	}
	
}
