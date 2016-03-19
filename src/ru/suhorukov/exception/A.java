package ru.suhorukov.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	
	BufferedReader reader;
	
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public A() throws IOException {
		reader.readLine();
	}

	public void m() throws Exception {
		//TODO: прописать действия
	}
}
