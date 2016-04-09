package ru.suhorukov.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTest {

	public static void main(String[] args) {
//		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
//				System.getProperty("user.dir") + "/src/ru/suhorukov/io/new/file.zip"))) {
//			ZipEntry fileTxtZip = new ZipEntry("file.txt");
//			zos.putNextEntry(fileTxtZip);
//			zos.write(Files.readAllBytes(
//					Paths.get(System.getProperty("user.dir"),
//							"src", "ru", "suhorukov" , "io", "new", "file.txt")));
//			zos.closeEntry();
//			ZipEntry otherFileTxtZip = new ZipEntry("1.txt");
//			zos.putNextEntry(otherFileTxtZip);
//			zos.write(Files.readAllBytes(
//					Paths.get(System.getProperty("user.dir"),
//							"src", "ru", "suhorukov" , "io", "new", "1.txt")));
//			zos.closeEntry();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try(ZipInputStream zis = new ZipInputStream(new FileInputStream(
				System.getProperty("user.dir") + "/src/ru/suhorukov/io/new/file.zip"))) {
			ZipEntry entry = null;
			while ((entry = zis.getNextEntry()) != null){
				System.out.println("Begin entry :" + entry.getName());
				BufferedReader reader = new BufferedReader(new InputStreamReader(zis));
				String line = "";
				while ((line = reader.readLine()) != null){
					System.out.println(line);
				}
				zis.closeEntry();
				System.out.println("End entry: " + entry.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
