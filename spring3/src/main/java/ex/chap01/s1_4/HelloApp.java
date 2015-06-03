package ex.chap01.s1_4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"bean1_4.xml"));
		MessageBean bean = factory.getBean("proxy", MessageBean.class);
		bean.sayHello();
	}
}
