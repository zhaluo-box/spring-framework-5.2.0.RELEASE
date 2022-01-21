package com.example.spring.learn.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

/**
 * Created  on 2022/1/21 17:17:18
 *
 * @author zl
 */
public class ResourceTest {

	public static void main(String[] args) throws Exception {
		resourceTest();
	}

	private static void resourceTest() throws IOException {
		FileSystemResource fileSystemResource = new FileSystemResource(
				"C:\\workspace\\spring-framework-5.2.0.RELEASE\\spring-learn-demo\\src\\main\\resources\\test-resource\\test.txt");
		File file = fileSystemResource.getFile();
		OutputStream outputStream = fileSystemResource.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("Hello File System Resource! ");
		bufferedWriter.flush();
		outputStream.close();
		bufferedWriter.close();
	}
}
