package ex.chap01.s1_5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingSample {

	@Around("execution(* sayHello())")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {

		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);

		System.out.printf("[LOG] METHOD: %s is calling\n", methodName);
		Object rtnObj = pjp.proceed();
		sw.stop();

		System.out.printf("[LOG] METHOD: %s was called\n", methodName);
		System.out.printf("[LOG] 처리시간 : %f 초\n", sw.getTotalTimeSeconds());

		return rtnObj;
	}
}
