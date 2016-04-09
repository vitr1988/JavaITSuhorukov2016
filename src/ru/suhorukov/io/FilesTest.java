package ru.suhorukov.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.List;

public class FilesTest {

	public static void main(String[] args) {
		Path filePath = Paths.get(
				System.getProperty("user.dir"),
					"src", "ru", "suhorukov" , "io", "new", "file.txt");
		try {
//			Files.createFile(filePath);
			Files.walkFileTree(filePath, new SimpleFileVisitor(){
			});
			
			List<String> strList = Files.readAllLines(filePath);
			for (String str : strList){
				System.out.println(str);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
