package ru.suhorukov.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int arg1, arg2;
		int result = -1;
		try {
			result = division(args);
		}
		catch(CustomException e){
			if (e.getException() instanceof IllegalArgumentException){
			}
		}
		catch(NumberFormatException e){
		}
		finally {
			System.out.println("Результат деления двух параметров программы = " + result);
		}
		
		System.out.println(getIndex());
	}

	private static int division(String[] args) throws CustomException {
		int arg1;
		int arg2;
		if (args.length != 2){
			throw new CustomException(new IllegalArgumentException("Длина массмива некорректна"));
		}
		else if (args[0] == null || args[1] == null){
			throw new CustomException(new IllegalArgumentException("NULL-параметр"));
		}
		
		arg1 = Integer.decode(args[0]);
		arg2 = Integer.decode(args[1]);
		int result = arg1 / arg2;// возможно, что arg2 = 0;
		return result;
	}

	public static int getIndex(){
		try {
			return 5;
		}
		catch(Throwable th){
			return -1;
		}
		finally {
			return 0;
		}
	}
	
}
