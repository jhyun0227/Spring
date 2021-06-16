package samp02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;
// MethodInterceptor �޼��带 ������ �� ����ä�� ���� ����
public class LogAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("�۾����� : " + methodName);
		// ���� �� �۾� ���� : ���⼭�� sayHello();
		Object obj = invocation.proceed();
		sw.stop();
		System.out.println("�۾����� : " + sw.getTotalTimeSeconds() + "��");
		return null;
	}

}
