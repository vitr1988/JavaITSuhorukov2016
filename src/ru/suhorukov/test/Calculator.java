package ru.suhorukov.test;

public class Calculator {
	
	public int summa(int arg1, int arg2){
		return arg1 + arg2;
	}
	
	public static int minus(int arg1, int arg2){
		return arg1 - arg2;
	}
	
	public static int multiply(int arg1, int arg2){
		return arg1 * arg2;
	}
	
	public static int division(int arg1, int arg2){
		return arg1 / arg2;
	}
	
	public static void main(String[] args) {
		if (summa(5, 4) == 9){
			System.out.println("Все ок!");
		}
	}
}
