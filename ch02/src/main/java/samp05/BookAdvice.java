package samp05;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAdvice {
	@Pointcut("execution(* getBook(String))")
	private void getBookPointcut() {}
	
	@Before("getBookPointcut()")
	public void before() {
		System.out.println("before log��");
	}
	
	@Around("getBookPointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("�۾� �� around");
		Object obj = pjp.proceed();
		System.out.println("�۾� �� around");
		return obj;
	}
	
	@After("getBookPointcut()")
	public void after() {
		System.out.println("after���� ���");
	}
	
	@AfterReturning(value = "getBookPointcut()", returning="book")
	public void afterRe(Book book) {
		System.out.println("after returning : " + book);
	}
	
	@AfterThrowing(value = "getBookPointcut()", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("���� : " + e.getMessage());
	}
}