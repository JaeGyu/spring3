package ex.chap01.s1_2;

import java.io.FileWriter;

public class FileOutputter implements Outputter {

	private String filePath;

	@Override
	public void output(String message) throws Exception {
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
