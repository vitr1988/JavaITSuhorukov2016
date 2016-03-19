package ru.suhorukov.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		try {
			readConosole();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readConosole() throws IOException {
		InputStream is = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String str = "";
		StringBuilder sb = new StringBuilder();
		try {
			while(!(str = reader.readLine()).equalsIgnoreCase("q")){
				sb.append(str);
			}
			System.out.println(sb.toString());
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			reader.close();
		}
	}
	
	private static void readConosoleMoreBeautiful() {
		InputStream is = System.in;
		String str = "", bufferedString = "";
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			while(!(str = reader.readLine()).equalsIgnoreCase("q")){
				bufferedString += str;
			}
			System.out.println(bufferedString);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void readConosoleByScanner() {
		Scanner scanner = new Scanner(System.in);
		String bufferedString = "";
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			if ("q".equals(str)){
				break;
			}
			else {
				bufferedString += str;
			}
		}
		scanner.close();
		System.out.println(bufferedString);
	}

}
