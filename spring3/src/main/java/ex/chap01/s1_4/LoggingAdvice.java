package ex.chap01.s1_4;

import org.aopalliance.intercept.Invocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();

		sw.start(methodName);
		System.out.printf("[LOG] METHOD: %s is calling.\n", methodName);
		Object rtnOnj = invocation.proceed();
		sw.stop();

		System.out.printf("[LOG] METHOD: %s was called.\n", methodName);
		System.out.printf("[LOG] 처리시간: %d 초\n", sw.getTotalTimeMillis() / 1000);

		return rtnOnj;
	}

}
