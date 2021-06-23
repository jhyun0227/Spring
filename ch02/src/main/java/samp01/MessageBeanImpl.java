package samp01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
// c + s + o
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
	private String greeting;

	public MessageBeanImpl() {
		System.out.println("�� Bean�� ������ ����");
	}

	public void setGreeting(String greeting) {
		System.out.println("�� ���� �޼��� ����");
		this.greeting = greeting;
	}

	public void setBeanName(String name) {
		System.out.println("�� Bean�� ����");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("�� BeanFactory ����");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("�� ������Ƽ ���� �Ϸ�");
	}

	public void aa() {
		System.out.println("�� �ʱ�ȭ �޼��� ����");
	}

	public void sayHello() {
		System.out.println(greeting);
	}

	public void destroy() throws Exception {
		System.out.println("���α׷� ����");
	}
}