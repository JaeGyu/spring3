package ex.chap02.s2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractUi {

	protected String getInputedString() {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));

		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			throw new IORuntimeException("콘솔에 입력을 받지 못했습니다.", e);
		}
	}
	
	abstract public void show();
	
	
	public static void main(String[] args) {
		AbstractUi a = new AbstractUi() {
			
			@Override
			public void show() {
				
			}
		};
		
		System.out.println(a.getInputedString());
	}
}
