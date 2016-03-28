package ru.suhorukov.reflection.annotation;

public class HandlerTest {

	@LogAnnotate(name="MonthLogger")
	public int nextDay(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@LogAnnotate(name="MonthLogger")
	public int getNextMonth(){
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
