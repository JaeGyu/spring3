package ex.chap01.s1_3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import ex.chap01.s1_2.MessageBean;

public class HelloApp {

	public static void main(String[] args) {
//		XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource(
//				"bean1_3.xml"));
//		factory.addBeanPostProcessor(new CustomBeanPostProcessor());

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"bean1_3.xml");
		
		MessageBean bean = context.getBean("messageBean", MessageBean.class);
		bean.sayHello();
		System.out.println("변경!");
	}

}
