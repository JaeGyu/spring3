package ex.chap01.s1_2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"bean1_2.xml"));

		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello();
	}
}
