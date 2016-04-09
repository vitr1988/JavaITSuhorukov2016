package ru.suhorukov.io;

import java.io.File;
import java.io.FileFilter;

public class FileUtil {

	public static boolean isFileExist(String file){
		File f = new File(file);
		return f.exists();
	}
	
	public static boolean createFile(String file){
		if (!isFileExist(file)){
			File f = new File(file);
			f.mkdirs();
			return true;
		}
		return false;
	}
	
	public static void observeFile(String file){
		File f = new File(file);
		File[] files = f.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				System.out.println(pathname.getName());
				return true;
			}
		});
		System.out.println(files.length);
	}
	
	public static String getFileSeparator(){
		return File.separator;
	}
}
