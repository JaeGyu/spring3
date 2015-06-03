package ex.chap01.s1_4;

public class MessageBeanImpl implements MessageBean {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Hello, %s!\n",name);
	}

}
