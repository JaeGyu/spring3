package ex.chap01.s1_2;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	
	private Outputter outputter;

	public MessageBeanImpl(String name) {
		super();
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println(message);
		
		try {
			outputter.output(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	

}
