package ru.suhorukov.reflection.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnotationTest {
	
	@LogAnnotate(name="ConstructorLogger")
	public AnnotationTest(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "deprecation", "unused", "rawtypes" })
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getDate());
		
		List list = new ArrayList();
		System.out.println("----------");
		AnnotationHandler.handle(AnnotationTest.class);
		System.out.println("----------");
		AnnotationHandler.handle(HandlerTest.class);
	}
	
	@LogAnnotate(name = "Logger1", logLevel = 3/*, ignore=true*/)
	public static void fillAndIterateArray(){
		
	}
	
	@LogAnnotate(name = "Logger2", logLevel = 13)
	public static void fillAndIterateMap(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@LogAnnotate(name = "Logger3")
	public static void fillAndIterateList(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author ViTr Иванов В.А.
	 */
	@Override
	public String toString(){
		return null;
	}
}