package samp04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // ������ɻ��� ó���ϴ� Ŭ����
@Component // ��ü ����
public class ProductAdvice {
	@Pointcut("execution(* getProduct(String))")
	private void hellPointcut() {
	}

	@Before("hellPointcut()")
	public void before() { // �� �۾� ���� ����
		System.out.println("before");
	}

	@Around("hellPointcut()") // �� �۾� �յڷ� ����
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("�۾��� around");
		Object obj = pjp.proceed();
		System.out.println("�۾��� around");
		return obj;
	}
	
	@After("hellPointcut()") // �� �۾� �Ŀ�
	public void after() {
		System.out.println("after");
	}
	
	// ������ �Ŀ� ��� ���� �޾� ���� ���� ��
	@AfterReturning(pointcut = "hellPointcut()", returning="product")
	public void afterRe(Product product) {
		System.out.println("afterRe : "+product);
	}
	
	// ������ �� ������ �߻��� ���
	@AfterThrowing(pointcut = "hellPointcut()", throwing="ex")
	public void afterTh(Throwable ex) {
		System.out.println(ex.getMessage());
	}
}
