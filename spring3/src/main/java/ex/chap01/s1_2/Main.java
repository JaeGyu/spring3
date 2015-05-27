package ex.chap01.s1_2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) {

		/* @Autowired 어노테이션 적용시 스프링 컨테이너는 ApplicationContext를 
		 * 사용해야 함*/
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
//				"bean1_2.xml"));
		
		ApplicationContext factory = new FileSystemXmlApplicationContext(
				"bean1_2.xml");

		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello();
	}
}
