package ru.suhorukov.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class IOTest {

	public static void main(String[] args) {
		write();
//		read();
	}

	private static void read() {
		try (BufferedReader reader = new BufferedReader(
				/*new FileReader(
						System.getProperty("user.dir") +
							"/src/ru/suhorukov/io/file.txt"))*/
				getReaderAsFile(System.getProperty("user.dir") +
							"/src/ru/suhorukov/io/file.txt"))) {
//			char[] array = new char[1024];
//			Integer result = 0;
//			while ((result = reader.read(array)) != -1){
//				String str = String.valueOf(array);
//				System.out.println(str);
//			}
//			int result = 0;
//			String str = "";
//			while ((result = reader.read()) != -1){
//				str += result + "";
//			}
//			System.out.println(str);
			String str = "";
			while((str = reader.readLine()) != null){
//				System.out.println(new String(str.getBytes("ISO-8859-1"), "UTF-8"));
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void write() {
		String fileName = System.getProperty("user.dir") + "/src/ru/suhorukov/io/new";
		FileUtil.createFile(fileName);
		FileUtil.observeFile(fileName);
		System.out.println(FileUtil.getFileSeparator());
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter(fileName + "/file.txt", true))) {
			
			writer.write("\nHello, World");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Reader getReaderAsFile(String file) throws FileNotFoundException, UnsupportedEncodingException{
		FileInputStream fis = new FileInputStream(file);
		return new InputStreamReader(fis, "UTF-8");
	}
}
