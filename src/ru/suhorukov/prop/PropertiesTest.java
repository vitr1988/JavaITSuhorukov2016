package ru.suhorukov.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("D:\\JavaProject\\JavaITSuhorukov2016\\src\\ru\\suhorukov\\prop\\properties.ini"));
			String str = prop.getProperty("value5435", "fgsdgsfhgsfgfsf");
			System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
