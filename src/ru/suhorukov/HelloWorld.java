package ru.suhorukov;

/**
 * Первый тестовый класс для демонстрации Java-возможностей
 */
public class HelloWorld {
	
	static int globarVar = -1;
	/**
	 * Данный метод является стартовым для запуска всего приложения
	 * 
	 * @param arguments	ожидаются два аргумента в виде числе для сложения
	 */
	public static void main(String[] arguments) {
		globarVar++;
		int length = arguments.length; // расчет длины массивы
		int index;
		index = 00;
		int binary = 0b1010; // 10
		int octet = 0123; // 83
		int hex = 0X123F; // 83
		long l = 45446545645646L;
		long number = 45446545645646L;
		byte b = 127;
		short sh = 789;
		char russianSymbolA = 'А';
		char analogSymbolA = '\u1040';  //полная аналогия
		double d = 1.2;
//		print((int) russianSymbolA);
		double res = 24 * 0.1;
//		print(res);
		float f = 2.4f;
		float fNum = (float) 24 * 0.1f;
//		print(fNum);
		boolean flag = true;
		boolean otherFlag = false;
		String name = "Иванов Виталий\nАндреевич";
		String twoLines = "Иванов \\" +
							"\nВиталий \t\r\n" +
								"\nАндреевич";
		boolean checked = length == 2;
		boolean result = checked | otherFlag; 
		boolean result2 = checked & flag;
		boolean result3 = !checked;
//		print(result3);
//		print(5 > 3 | 4 > 25 | 0 == 0);//??
//		print(5 > 3 && 104 > 25 && 0 == 0);//??
		
		// Наша программа ожидает на вход два параметра
		
		int arg1 = Integer.decode(arguments[0]);
		int arg2 = Integer.decode(arguments[1]);
		double dfda = Double.parseDouble("1.2");
		
		if (checked){
			/* Здесь могла быть Ваша реклама
			 * Вторая строка комментарии
			 */
			int resultSumma = 0;
			for (String arg : arguments){
				resultSumma += Integer.decode(arg);
			}
//			print(resultSumma);
			
		}
		// если это не так
		else {
			// происходит вывод в консоль..
//			print("Ожидается два аргумента!");
		}	
		
		showArithmeticOperations();
		{
//			print("Print1!");
//			print("Print2!");
//			print("Print3!");
		}
	}
	
	/**
	 * Метод, печатающий в консоль строку-параметр
	 * @param str	строка-параметр
	 */
	public static void print(Object str){
		System.out.println(str);
	}
	
	public static void showArithmeticOperations(){
		int arg1 = 25;
		int arg2 = 124;
//		print(arg2/arg1);//?
//		print(124./.25);//?
		
		int result = arg1 + arg2;
		int result2 = arg1 - arg2;
		int result3 = arg1 * arg2;
		int result5 = arg1 / arg2;
		int result6 = arg2 % arg1; // 24
		arg1++;
		arg2--;
		float d = (float) (2f + 2.2) ;
		
		byte b1 = (byte) 1024; //??
//		print("Byte:" + b1);
		
		++arg1;
		--arg2;
		
		int a = 10, b = 4;
//		print(++a + ++b);//16 = 11 + 5
//		print(a++ + b++);//14 = 10 + 4;
//		print(a); //11
//		print(b); //5
		
//		print(--a + b++);//?
//		a++; a = a + 1;
//		++a; a = a + 1;
		boolean res = a == b;
		boolean res1 = a > b;
		boolean res2 = a < b;
		boolean res3 = a != b;
		boolean res4 = a <= b;
		boolean res5 = a >= b;
		int c = 7;
		boolean res6 = a <= c && c <= b;
		
		int d1 = a & b;
		int e = a | b;
		
		{
			int i = d1 << e;
			int k = d1 >> e;
			{
				i++;
				{
//					print(i);
				}
			}
		}
//		print(i); заведомо внесена ошибка
		
		int compoundResult = 0;
		compoundResult += d1;// compoundResult = compoundResult + d1;
		compoundResult -= d1;
//		compoundResult /= d1;
//		compoundResult %= d1;
		compoundResult <<= d1;
		
		byte ex = 127;
		ex = (byte) (ex + 1024);
		ex += 1024;// ex = (byte)(ex + 1024); 
		
		int x = ex > 0 ? 15 : 10;
		
//		print(2 + 2* 2);
//		print((2 + 2)* 2);
		
		showLoops();
		demonstrateSwitchOperator();
	}
	
	public void demontstrateOperators(){
		int b = 12;
		if (17 + 32 > 0){
			int a = 78 - 25;
//			print(a);
		}
		else if (b == 12){
			int a = 78 + 25;
//			print(a);
		}
		else {
//			print("Конец работы программы!");
		}
		
		String color = "red";
		if (color.equals("yellow")){
//			print("Будьте осторожны!");
		}
		else if (color.equals("red")){
//			print("Запрет!");
		}
		else if (color.equals("green")){
//			print("Разрешено идти!");
		}
		
		int x = 9;
		int y = 99;
		int z = 0;
		if (x >= 10) { 
			if (y == 100) {
				z = 1; 
			}
		}	
		else {
			z = 2;
		}
//		print(z);
		demonstrateSwitchOperator();
	}
	
	public static void showLoops(){
		int i = 0;
		boolean flag = i < 100;
		
		while(flag){
//			print("While Loop iteration # " + i);
			i++;
			flag = i < 100;
		}
		
		do {
//			print("Do-while Loop iteration # " + i);
			i++;
			flag = i < 100;
		} while(flag);
		
		for (int index = 0; index < 25; index++){
//			print("For Loop iteration # " + index);
		}
		
	}
	
	public static void demonstrateSwitchOperator(){
		String color = "red";
		switch(color) {
			 case "yellow" : print("Будьте осторожны!"); break;
			 case "red" : print("Запрет!"); break;
			 case "green" :
			 case "orange" :
			 case "pink" : {	 
				 print("Разрешено идти!!"); 
				 break;
			 }
			 default : 
				 print("Такой цвет не возможен"); break;
		}
		String col = null;
		col.length();
	}
}
