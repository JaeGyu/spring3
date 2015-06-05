package ex.chap01.s1_5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		System.out.println("1!2^");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"bean1_5.xml");

		MessageBean bean = context.getBean("targetBean", MessageBean.class);
		bean.sayHello();
	}
}
