package ex.chap01.s1_3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import ex.chap01.s1_2.MessageBean;

public class MessageBeanImpl implements MessageBean, BeanNameAware,
		BeanFactoryAware, InitializingBean, DisposableBean {

	private String greeting;
	private String name;
	private String beanName;
	private BeanFactory beanFactory;

	public MessageBeanImpl() {
		System.out.println("1. Bean의 생성자 실행");
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("2. 설정 메서드 실행");
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("3. Bean이름 지정");
		this.beanName = beanName;
		System.out.println("-> " + this.beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("4. BeanFactory 지정");
		this.beanFactory = beanFactory;
		System.out.println("-> " + this.beanFactory.getClass());
	}

	public void init() {
		System.out.println("7. 초기화 메서드 실행");
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("종료");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6. 프로퍼티 지정 완료");
	}

	@Override
	public void sayHello() {
		System.out.println(greeting + beanName + "!");
	}

}
