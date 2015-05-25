package ex.chap01.sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import ex.chap01.sample2.MessageBean;

public class HelloApp {
	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"beans.xml"));
		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello("Spring");
		
	}
}
