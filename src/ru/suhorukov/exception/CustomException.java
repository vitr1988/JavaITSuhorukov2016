package ru.suhorukov.exception;

public class CustomException extends Exception {

	private Throwable th;

	public CustomException(Throwable th) {
		this.th = th;
	}
	
	public Throwable getException(){
		return th;
	}
	
	@Override
	public String toString(){
		return "Произошло программное исключение " + th;
	}
}
